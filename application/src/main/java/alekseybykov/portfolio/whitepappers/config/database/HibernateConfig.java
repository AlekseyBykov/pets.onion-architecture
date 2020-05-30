package alekseybykov.portfolio.whitepappers.config.database;

import alekseybykov.portfolio.whitepappers.audit.AuditInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Aleksey Bykov
 * @since 04.10.2019
 */
@Component
@RequiredArgsConstructor
public class HibernateConfig implements HibernatePropertiesCustomizer {

    private final AuditInterceptor auditInterceptor;

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put("hibernate.session_factory.interceptor", auditInterceptor);
    }
}
