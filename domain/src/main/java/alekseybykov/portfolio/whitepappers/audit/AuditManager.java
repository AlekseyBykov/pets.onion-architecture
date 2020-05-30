package alekseybykov.portfolio.whitepappers.audit;

import alekseybykov.portfolio.whitepappers.entities.Auditable;

/**
 * @author Aleksey Bykov
 * @since 24.09.2019
 */
public interface AuditManager {

    void performPrePersistLogic(Auditable auditable);

    void performPreUpdateLogic(Auditable auditable);
}
