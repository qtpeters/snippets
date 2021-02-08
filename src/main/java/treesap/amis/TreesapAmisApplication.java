package treesap.amis;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class TreesapAmisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TreesapAmisApplication.class, args);
        log.info("TREESAP AMIS Interface Service");
    }

}
