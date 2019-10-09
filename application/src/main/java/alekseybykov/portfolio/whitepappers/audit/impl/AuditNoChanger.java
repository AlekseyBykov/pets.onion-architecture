//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.audit.impl;

import alekseybykov.portfolio.whitepappers.audit.AuditManager;
import alekseybykov.portfolio.whitepappers.entities.Auditable;
import lombok.RequiredArgsConstructor;

/**
 * Currently disabled. See solution based on Hibernate interceptor.
 *
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-24
 */
@RequiredArgsConstructor
public class AuditNoChanger implements AuditManager {
    @Override
    public void performPrePersistLogic(Auditable auditable) {

    }

    @Override
    public void performPreUpdateLogic(Auditable auditable) {

    }
}
