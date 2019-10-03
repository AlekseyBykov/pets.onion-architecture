package alekseybykov.portfolio.component.audit;

import alekseybykov.portfolio.component.entities.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-02
 */
@Component
@ConditionalOnProperty(name = "audit.enabled", havingValue = "true", matchIfMissing = true)
public interface Auditor {

    void embedAuditBeforeCreating(Object entity,
                                  Serializable id,
                                  Object[] state,
                                  String[] propertyNames,
                                  User currentEmployee);

    void embedAuditBeforeChanging(Object entity,
                                  Serializable id,
                                  Object[] currentState,
                                  Object[] previousState,
                                  String[] propertyNames,
                                  User currentEmployee);
}
