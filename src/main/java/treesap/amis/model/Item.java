package treesap.amis.model;

import lombok.*;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
    @XmlAttribute(name = "isRegistered")
    private boolean registered;
    @XmlElement(name = "isRegisteredForSecurityQuestions")
    private boolean registeredForSecurityQuestions;
    @XmlElement(name = "accountStartDate")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime accountStartDate;
    @XmlElement(name = "emailAddress")
    private String emailAddress;
    @XmlElement(name = "firstName")
    private String firstName;
    @XmlElement(name = "isEnabled")
    private boolean enabled;
    @XmlElement(name = "isLocked")
    private boolean locked;
    @XmlElement(name = "lastLogin")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime lastLogin;
    @XmlElement(name = "lastModifiedBy")
    private String lastModifiedBy;
    @XmlElement(name = "lastModifiedOn")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime lastModifiedOn;
    @XmlElement(name = "lastName")
    private String lastName;
    @XmlElement(name = "PID")
    private String pid;
    @XmlElement(name = "userID")
    private String userId;
    private List<Token> tokens;
    @XmlElement(name = "CustomAttributes")
    private CustomAttributes customAttributes;
    @XmlElement(name = "securityDomain")
    private String securityDomain;
    @XmlElement(name = "identitySource")
    private String identitySource;
    @XmlElement(name = "isInternal")
    private boolean internal;
    @XmlElement(name = "badPasscodeCount")
    private int badPasscodeCount;
    @XmlElement(name = "passwordModifiedDate")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime passwordModifiedDate;
    @XmlElement(name = "isFixedPasscordSet")
    private boolean fixedPasscodeSet;
}
