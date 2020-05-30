package alekseybykov.portfolio.whitepappers.config.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import static java.util.Objects.isNull;

/**
 * @author Aleksey Bykov
 * @since 08.09.2019
 */
@Configuration
@EnableJpaRepositories(basePackages = {"alekseybykov.portfolio.whitepappers.repositories"})
@EnableTransactionManagement
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.flyway.schemas}")
    private String schemas;

    @Value("${spring.flyway.locations}")
    private String[] locations;

    @Value("${spring.flyway.out-of-order}")
    private Boolean outOfOrder;

    @Value("${spring.datasource.hikari.maximumPoolSize:5}")
    private String maximumPoolSize;

    @Value("${schema.recreate:false}")
    private boolean schemaRecreate;

    private HikariDataSource dataSource;

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        Flyway flyway =  Flyway.configure()
            .dataSource(getDatasource())
            .schemas(schemas)
            .locations(locations)
            .baselineOnMigrate(schemaRecreate)
            .outOfOrder(outOfOrder)
            .load();
        if (schemaRecreate) {
            flyway.clean();
        }
        flyway.repair();
        flyway.migrate();

        return flyway;
    }

    private DataSource getDatasource() {
        if (isNull(dataSource)) {
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setDriverClassName(driverClassName);
            hikariConfig.setJdbcUrl(url);
            hikariConfig.setUsername(user);
            hikariConfig.setPassword(password);
            hikariConfig.setMaximumPoolSize(Integer.parseInt(maximumPoolSize));
            hikariConfig.setAutoCommit(false);

            dataSource = new HikariDataSource(hikariConfig);
        }
        return dataSource;
    }
}
