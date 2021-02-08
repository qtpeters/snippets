package treesap.amis.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import treesap.amis.dto.Response;
import treesap.amis.model.SearchType;
import treesap.amis.service.PersonService;

import javax.xml.bind.JAXBException;

@RestController
@RequestMapping("/api/v1/persons")
@Api(value="person", description = "Operations pertaining to Persons in the RSA AM")
public class RsaPersonController {
    private PersonService personService;

    @Autowired
    public RsaPersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    @ApiOperation(value = "View a list of all user information in the RSA backend", response = Response.class)
    public Response getAllPersons() throws JAXBException {
        return Response
                .ok()
                .setPayload(personService.getAllPersons());
    }

    @GetMapping("/search")
    @ApiOperation(value = "Search for user information in the RSA backend matching the criteria for the userID field", response = Response.class)
    public Response getPersonBySearchCriteria(
            @ApiParam(
                    name = "userSearchString",
                    type = "String",
                    value = "a wildcard searchable value contained in the userID",
                    example = "amis",
                    required = true
            )
            @RequestParam String userSearchString,
            @ApiParam(
                    name = "searchType",
                    type = "String",
                    value = "determines the search scope, including these valid options: EQUALS, BEGINS_WITH, ENDS_WITH, CONTAINS",
                    example = "equals",
                    required = true
            )
            @RequestParam SearchType searchType,
            @ApiParam(
                    name = "sd",
                    type = "String",
                    value = "optional Security Domain (sd=) to limit user search to a domain",
                    example = "jade",
                    required = false
            )
            @RequestParam(required = false) String sd) throws JAXBException {
        return Response
                .ok()
                .setPayload(personService.getPersons(userSearchString, searchType, sd));
    }


    @GetMapping("/assign")
    @ApiOperation(value = "Search for user information in the RSA backend matching the criteria for the userID field", response = Response.class)
    public Response assignNewTokenToUser(
            @ApiParam(
                    name = "userId",
                    type = "String",
                    value = "the user identifier",
                    example = "amis",
                    required = true
            )
            @RequestParam String userId,
            @ApiParam(
                    name = "serialNumber",
                    type = "String",
                    value = "the token serial number",
                    example = "411409155",
                    required = true
            )
            @RequestParam String serialNumber) throws JAXBException {
        return Response
                .ok()
                .setPayload(personService.assignTokenToUser(userId, serialNumber));
    }
}
