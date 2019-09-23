package alekseybykov.portfolio.component.audit.impl;

import alekseybykov.portfolio.component.audit.AuditManager;
import alekseybykov.portfolio.component.entities.Auditable;

public class AuditNoChanger implements AuditManager {
    @Override
    public void performPrePersistLogic(Auditable auditable) {

    }

    @Override
    public void performPreUpdateLogic(Auditable auditable) {

    }
}
