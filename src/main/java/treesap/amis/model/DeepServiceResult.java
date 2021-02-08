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
public class DeepServiceResult {
    @XmlAttribute(name = "result")
    private boolean result = false;
    @XmlElement(name = "DeepUserSearchResults")
    private UserSearchResults userSearchResults = new UserSearchResults();
}
