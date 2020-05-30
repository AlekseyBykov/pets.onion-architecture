package alekseybykov.portfolio.whitepappers.audit;

import alekseybykov.portfolio.whitepappers.entities.User;

import java.io.Serializable;

/**
 * @author Aleksey Bykov
 * @since 03.10.2019
 */
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
