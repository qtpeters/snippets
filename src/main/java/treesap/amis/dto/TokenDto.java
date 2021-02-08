package treesap.amis.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenDto {
    private String replaceTokenSerialNumber;
    private String replacementStatus;
    private String serialNumber;
    private boolean tokenLost;
    private String assignedTo;
    private LocalDateTime dateAssigned;
    private LocalDateTime expirationDate;
    private LocalDateTime startDate;
    private boolean enabled;
    private String securityDomain;
}
