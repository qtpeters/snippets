package treesap.amis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Item")
public class TokenItem {
    @XmlAttribute(name = "replaceTokenPair")
    private String replaceTokenPair;
    @XmlAttribute(name = "replacementStatus")
    private String replacementStatus;
    @XmlAttribute(name = "serialNumber")
    private String serialNumber;
    @XmlAttribute(name = "temporaryTokenCodeUsed")
    private boolean temporaryTokenCodeUsed;
    @XmlAttribute(name = "tokenLost")
    private boolean tokenLost;

    @XmlElement(name = "algorithm")
    private String algorithm;
    @XmlElement(name = "assignedTo")
    private String assignedTo;
    @XmlElement(name = "dateAssigned")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime dateAssigned;
    @XmlElement(name = "deviceGuid")
    private String deviceGuid;
    @XmlElement(name = "securityDomain")
    private String securityDomain;
    @XmlElement(name = "deviceName")
    private String deviceName;
    @XmlElement(name = "expirationDate")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime expirationDate;
    @XmlElement(name = "formFactor")
    List<String> formFactor;
    @XmlElement(name = "hasBeenUsed")
    private boolean hasBeenUsed;
    @XmlElement(name = "interval")
    private int interval;
    @XmlElement(name = "enabled")
    private boolean enabled;
    @XmlElement(name = "newPinMode")
    private boolean newPinMode;
    @XmlElement(name = "pinSet")
    private boolean pinSet;
    @XmlElement(name = "lastPinModifiedDate")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime lastPinModifiedDate;
    @XmlElement(name = "length")
    private int length;
    @XmlElement(name = "nextTokenMode")
    private boolean nextTokenMode;
    @XmlElement(name = "pinType")
    private String pinType;
    @XmlElement(name = "startDate")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime startDate;
    @XmlElement(name = "tokenType")
    private int tokenType;
}
