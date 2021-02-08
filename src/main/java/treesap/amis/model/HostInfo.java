package treesap.amis.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "amis")
public class HostInfo {
    private String systemName;
    private String host;
    private String protocol;
    private String port;
    private String rsaToken;
    private String rsaTokenType;
    private String pswd;
    private String serviceAct;
}
