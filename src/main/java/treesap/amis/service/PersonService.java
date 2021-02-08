package treesap.amis.service;

import treesap.amis.dto.PersonDto;
import treesap.amis.model.SearchType;

import javax.xml.bind.JAXBException;
import java.util.Set;

public interface PersonService {
    Set<PersonDto> getPersons(String userSearchString, SearchType searchType, String securityDomain) throws JAXBException;
    Set<PersonDto> getAllPersons() throws JAXBException;
    String assignTokenToUser(String userId, String serialNumber) throws JAXBException;
}
