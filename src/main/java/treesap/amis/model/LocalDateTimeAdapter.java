package treesap.amis.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
    private DateTimeFormatter dateFormatWithMillis = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    @Override
    public LocalDateTime unmarshal(String dateTime) throws Exception {
        LocalDateTime parsedDateTime;
        try {
            parsedDateTime = LocalDateTime.parse(dateTime, dateFormatWithMillis);
        } catch(Throwable t) {
            parsedDateTime = LocalDateTime.parse(dateTime, dateFormat);
        }
        return parsedDateTime;
    }

    @Override
    public String marshal(LocalDateTime dateTime) throws Exception {
        return dateTime.format(dateFormat);
    }
}
