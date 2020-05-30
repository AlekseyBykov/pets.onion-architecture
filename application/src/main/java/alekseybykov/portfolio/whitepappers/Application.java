package alekseybykov.portfolio.whitepappers;

import alekseybykov.portfolio.whitepappers.config.database.DataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

/**
 * @author Aleksey Bykov
 * @since 08.09.2019
 */
@SpringBootApplication(scanBasePackages = {"alekseybykov.portfolio.whitepappers"})
@EntityScan(basePackages = {"alekseybykov.portfolio.whitepappers.entities"})
@Import({DataSourceConfig.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
