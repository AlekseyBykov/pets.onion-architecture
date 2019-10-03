//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.audit;

import alekseybykov.portfolio.component.entities.User;

import java.io.Serializable;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-02
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
