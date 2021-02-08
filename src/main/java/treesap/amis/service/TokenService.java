package treesap.amis.service;

import treesap.amis.dto.TokenDto;

import javax.xml.bind.JAXBException;
import java.util.Set;

public interface TokenService {

    Set<TokenDto> getTokens(String userId) throws JAXBException;
}
