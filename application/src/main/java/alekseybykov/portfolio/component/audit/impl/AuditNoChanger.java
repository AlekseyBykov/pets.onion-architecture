package alekseybykov.portfolio.component.audit.impl;

import alekseybykov.portfolio.component.audit.AuditManager;
import alekseybykov.portfolio.component.entities.Auditable;

/**
 * Currently disabled. See solution based on Hibernate interceptor.
 *
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-24
 */
public class AuditNoChanger implements AuditManager {
    @Override
    public void performPrePersistLogic(Auditable auditable) {

    }

    @Override
    public void performPreUpdateLogic(Auditable auditable) {

    }
}
