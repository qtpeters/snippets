package treesap.amis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@ToString
@XmlRootElement(name = "serviceResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceResult {
    @XmlAttribute(name = "errorMessage")
    private String errorMessage;
    @XmlAttribute(name = "result")
    private boolean result = false;
    @XmlElement(name = "UserSearchResults")
    private UserSearchResults userSearchResults = new UserSearchResults();
}
