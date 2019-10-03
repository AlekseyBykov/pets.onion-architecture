//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.config.audit;

import alekseybykov.portfolio.component.audit.AuditManager;
import alekseybykov.portfolio.component.audit.impl.AuditChanger;
import alekseybykov.portfolio.component.audit.impl.AuditNoChanger;
import alekseybykov.portfolio.component.services.audit.AuditService;
import alekseybykov.portfolio.component.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-23
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