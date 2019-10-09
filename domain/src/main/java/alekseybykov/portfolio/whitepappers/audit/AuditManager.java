//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.audit;

import alekseybykov.portfolio.whitepappers.entities.Auditable;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-23
 */
public interface AuditManager {

    void performPrePersistLogic(Auditable auditable);

    void performPreUpdateLogic(Auditable auditable);
}
