//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.services.audit;

import alekseybykov.portfolio.whitepappers.entities.Audit;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-24
 */
public interface AuditService {
    Audit getAudit(String entityName, Long entityId);
}
