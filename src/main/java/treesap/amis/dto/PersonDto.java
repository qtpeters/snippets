package treesap.amis.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import treesap.amis.model.CustomAttributesDto;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDto {
    private boolean registered;
    private boolean registeredForSecurityQuestions;
    private LocalDateTime accountStartDate;
    private String firstName;
    private boolean enabled;
    private boolean locked;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedOn;
    private String lastName;
    private String pid;
    private String userId;
    private CustomAttributesDto customAttributes;
    private String securityDomain;
    private String identitySource;
    private boolean internal;
    private int badPasscodeCount;
    private boolean fixedPasscodeSet;
}
