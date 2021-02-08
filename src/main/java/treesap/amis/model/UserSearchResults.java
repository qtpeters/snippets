package treesap.amis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSearchResults {
    @XmlAttribute(name = "Count")
    private int count;
    @XmlElement(name = "Item")
    private List<Item> items = new ArrayList<>();

    public UserSearchResults() {
        count = items.size();
    }

    public UserSearchResults(List<Item> items) {
        this.items = items;
        count = items.size();
    }
}
