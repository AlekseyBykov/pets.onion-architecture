package alekseybykov.portfolio.whitepappers.config.audit;

import alekseybykov.portfolio.whitepappers.audit.AuditManager;
import alekseybykov.portfolio.whitepappers.audit.impl.AuditChanger;
import alekseybykov.portfolio.whitepappers.audit.impl.AuditNoChanger;
import alekseybykov.portfolio.whitepappers.services.audit.AuditService;
import alekseybykov.portfolio.whitepappers.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Aleksey Bykov
 * @since 24.09.2019
 */
@Configuration
public class AuditConfig {

    @Autowired
    private UserService userService;

    @Autowired
    private AuditService auditService;

    @Bean
    @Profile("e2e")
    public AuditManager getAuditNoChanger() {
        return new AuditNoChanger();
    }

    @Bean
    @Profile("local")
    public AuditManager getAuditChanger() {
        return new AuditChanger(userService, auditService);
    }
}