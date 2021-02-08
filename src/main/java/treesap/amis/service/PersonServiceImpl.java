package treesap.amis.service;

import io.micrometer.core.instrument.LongTaskTimer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import treesap.amis.dto.PersonDto;
import treesap.amis.exception.RsaAmisException;
import treesap.amis.model.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class PersonServiceImpl implements PersonService {
    private RestTemplate restTemplate;
    private HostInfo hostInfo;

    public PersonServiceImpl(RestTemplate restTemplate, HostInfo hostInfo) {
        this.restTemplate = restTemplate;
        this.hostInfo = hostInfo;
    }

    @Override
    public Set<PersonDto> getPersons(String userSearchString, SearchType searchType, String securityDomain)
            throws JAXBException {
        Set<PersonDto> result = new HashSet<>();
        SimpleMeterRegistry registry = new SimpleMeterRegistry();
        LongTaskTimer timer = LongTaskTimer.builder(
                String.format("amis.getPersons(userSearchString:%s, searchType:%s, securityDomain:%s)",
                        userSearchString, searchType, securityDomain))
                .register(registry);
        LongTaskTimer.Sample currentTaskId = timer.start();
        StringBuffer url = new StringBuffer();
        url.append(hostInfo.getProtocol())
                .append("://")
                .append(hostInfo.getHost())
                .append(":")
                .append(hostInfo.getPort());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.set(hostInfo.getRsaTokenType(), hostInfo.getRsaToken());
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<String> response;
        if (securityDomain == null) {
            url.append("/am8/user/search/{userSearchString}?searchType={searchType}");
            response =
                    restTemplate.exchange(url.toString(), HttpMethod.GET, entity, String.class,
                            userSearchString, searchType.typeString);
        } else {
            url.append("/am8/user/search/{userSearchString}?searchType={searchType}&sd={securityDomain}");
            response =
                    restTemplate.exchange(url.toString(), HttpMethod.GET, entity, String.class,
                            userSearchString, searchType.typeString, securityDomain);
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(ServiceResult.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(response.getBody());
        ServiceResult serviceResult = (ServiceResult) unmarshaller.unmarshal(reader);
        for (Item item : serviceResult.getUserSearchResults().getItems()) {
            PersonDto person = new PersonDto();
            person.setAccountStartDate(item.getAccountStartDate());
            person.setFirstName(item.getFirstName());
            person.setEnabled(item.isEnabled());
            person.setLocked(item.isLocked());
            person.setLastModifiedOn(item.getLastModifiedOn());
            person.setLastModifiedBy(item.getLastModifiedBy());
            person.setLastName(item.getLastName());
            person.setPid(item.getPid());
            person.setUserId(item.getUserId());
            if (item.getCustomAttributes() != null) {
                CustomAttributesDto customAttributes = new CustomAttributesDto();
                person.setCustomAttributes(customAttributes);
            }
            person.setSecurityDomain(item.getSecurityDomain());
            person.setIdentitySource(item.getIdentitySource());
            person.setInternal(item.isInternal());
            person.setBadPasscodeCount(item.getBadPasscodeCount());
            person.setFixedPasscodeSet(item.isFixedPasscodeSet());
            result.add(person);
        }
        long timeElapsed = currentTaskId.stop();
        log.debug("Time to execute AMIS getPerson(userSearchString: {}, searchType: {}, sd: {}) query time - {} s",
                userSearchString, searchType.typeString, securityDomain,
                (timeElapsed / (int) 1e9));
        return result;
    }

    @Override
    public Set<PersonDto> getAllPersons() throws JAXBException {
        return getPersons("*", SearchType.CONTAINS, null);
    }

    @Override
    public String assignTokenToUser(String userId, String serialNumber) throws JAXBException {
        String result;
        SimpleMeterRegistry registry = new SimpleMeterRegistry();
        LongTaskTimer timer = LongTaskTimer.builder(
                String.format("amis.assignTokenToUser(userId:%s, serialNumber:%s)",
                        userId, serialNumber))
                .register(registry);
        LongTaskTimer.Sample currentTaskId = timer.start();
        StringBuffer url = new StringBuffer();
        url.append(hostInfo.getProtocol())
                .append("://")
                .append(hostInfo.getHost())
                .append(":")
                .append(hostInfo.getPort());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.set(hostInfo.getRsaTokenType(), hostInfo.getRsaToken());
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<String> response;
        url.append("/am8/user/assign/{userID}/{serialNumber}");
        response =
                restTemplate.exchange(url.toString(), HttpMethod.GET, entity, String.class,
                        userId, serialNumber);
        JAXBContext jaxbContext = JAXBContext.newInstance(ServiceResult.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(response.getBody());
        ServiceResult serviceResult = (ServiceResult) unmarshaller.unmarshal(reader);
        long timeElapsed = currentTaskId.stop();
        log.debug("Time to execute AMIS assignToken(userID: {}, serialNumber: {}) query time - {} seconds",
                userId, serialNumber,
                (timeElapsed / (int) 1e9));
        if (!serviceResult.isResult()) {
            // Figure out what exception to throw
            String errorMessage = serviceResult.getErrorMessage();
            String exceptionFlag = "Exception :";
            int beginIndex = errorMessage.indexOf("Exception : ");
            int endIndex = errorMessage.indexOf(" [", beginIndex);
            String errorText = errorMessage.substring(beginIndex + exceptionFlag.length(), endIndex);
            throw new RsaAmisException(errorText);
        }
        return serialNumber;
    }
}
