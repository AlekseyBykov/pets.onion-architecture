//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.config.database;

import alekseybykov.portfolio.component.audit.AuditInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-04
 */
@Component
@RequiredArgsConstructor
public class HibernateConfiguration implements HibernatePropertiesCustomizer {

    private final AuditInterceptor auditInterceptor;

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put("hibernate.session_factory.interceptor", auditInterceptor);
    }
}
