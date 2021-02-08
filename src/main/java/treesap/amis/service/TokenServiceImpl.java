package treesap.amis.service;

import io.micrometer.core.instrument.LongTaskTimer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import treesap.amis.dto.TokenDto;
import treesap.amis.model.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class TokenServiceImpl implements TokenService {
    private RestTemplate restTemplate;
    private HostInfo hostInfo;

    public TokenServiceImpl(RestTemplate restTemplate, HostInfo hostInfo) {
        this.restTemplate = restTemplate;
        this.hostInfo = hostInfo;
    }

    @Override
    public Set<TokenDto> getTokens(String userId) throws JAXBException {
        Set<TokenDto> result = new HashSet<>();
        SimpleMeterRegistry registry = new SimpleMeterRegistry();
        LongTaskTimer timer = LongTaskTimer.builder(
                String.format("amis.getTokens(userId:%s)", userId))
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
        url.append("/am8/token/info/UserID/{userId}");
        response = restTemplate.exchange(url.toString(), HttpMethod.GET, entity, String.class, userId);
        JAXBContext jaxbContext = JAXBContext.newInstance(TokenServiceResult.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(response.getBody());
        TokenServiceResult tokenServiceResult = (TokenServiceResult) unmarshaller.unmarshal(reader);
        for (TokenItem item : tokenServiceResult.getTokenInfoResults().getItems()) {
            TokenDto token = new TokenDto();
            token.setAssignedTo(item.getAssignedTo());
            token.setDateAssigned(item.getDateAssigned());
            token.setEnabled(item.isEnabled());
            token.setExpirationDate(item.getExpirationDate());
            token.setReplacementStatus(item.getReplacementStatus());
            token.setReplaceTokenSerialNumber(item.getReplaceTokenPair());
            token.setSecurityDomain(item.getSecurityDomain());
            token.setSerialNumber(item.getSerialNumber());
            token.setStartDate(item.getStartDate());
            token.setTokenLost(item.isTokenLost());
            result.add(token);
        }
        long timeElapsed = currentTaskId.stop();
        log.debug("Time to execute AMIS getTokens(userId: {}) query time - {} s",
                userId, (timeElapsed / (int) 1e9));
        return result;
    }
}
