package treesap.amis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "tokens")
public class Token {
    @XmlAttribute(name = "replacementStatus")
    private String replacementStatus;
    @XmlAttribute(name = "serialNumber")
    private String serialNumber;
    @XmlAttribute(name = "temporaryTokenCodeUsed")
    private boolean temporaryTokenCodeUsed;
    @XmlAttribute(name = "tokenLost")
    private boolean tokenLost;
    @XmlElement(name = "guid")
    private String guid;
    @XmlElement(name = "lostMode")
    private boolean lostMode;
    @XmlElement(name = "algorithm")
    private String algorithm;
    @XmlElement(name = "assignedTo")
    private String assignedTo;
    @XmlElement(name = "expirationDate")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime expirationDate;
    @XmlElement(name = "enabled")
    private boolean enabled;
    @XmlElement(name = "newPinMode")
    private boolean newPinMode;
    @XmlElement(name = "pinSet")
    private boolean pinSet;
    @XmlElement(name = "nextTokenMode")
    private boolean nextTokenMode;
    @XmlElement(name = "securityDomain")
    private String securityDomain;
    @XmlElement(name = "tokenType")
    private int tokenType;
}
