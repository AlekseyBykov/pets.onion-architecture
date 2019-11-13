package alekseybykov.portfolio.whitepappers.audit;

import alekseybykov.portfolio.whitepappers.entities.Auditable;

public interface AuditManager {

    void performPrePersistLogic(Auditable auditable);

    void performPreUpdateLogic(Auditable auditable);
}
