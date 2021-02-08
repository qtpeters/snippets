package treesap.amis.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import treesap.amis.dto.Response;
import treesap.amis.model.SearchType;
import treesap.amis.service.PersonService;
import treesap.amis.service.TokenService;

import javax.xml.bind.JAXBException;

@RestController
@RequestMapping("/api/v1/tokens")
@Api(value="tokens", description = "Operations pertaining to Tokens in the RSA AM")
public class RsaTokenController {
    private TokenService tokenService;

    @Autowired
    public RsaTokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("/search")
    @ApiOperation(value = "Search for token information in the RSA backend matching the criteria for the userID field", response = Response.class)
    public Response getTokenBySearchCriteria(
            @ApiParam(
                    name = "userId",
                    type = "String",
                    value = "a wildcard searchable value contained in the userID",
                    example = "amis",
                    required = true
            )
            @RequestParam String userId) throws JAXBException {
        return Response
                .ok()
                .setPayload(tokenService.getTokens(userId));
    }
}
