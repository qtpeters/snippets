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
public class TokenInfoResults {
    @XmlAttribute(name = "Count")
    private int count;
    @XmlElement(name = "Item")
    private List<TokenItem> items = new ArrayList<>();

    public TokenInfoResults() {
        count = items.size();
    }

    public TokenInfoResults(List<TokenItem> items) {
        this.items = items;
        count = items.size();
    }
}
