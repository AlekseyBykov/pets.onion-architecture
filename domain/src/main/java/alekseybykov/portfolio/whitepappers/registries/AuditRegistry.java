//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.registries;

import alekseybykov.portfolio.whitepappers.entities.Audit;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-24
 */
public interface AuditRegistry {
    Audit findAudit(String entityName, Long entityId);
}
