package alekseybykov.portfolio.whitepappers.audit.impl;

import alekseybykov.portfolio.whitepappers.audit.AuditManager;
import alekseybykov.portfolio.whitepappers.entities.Auditable;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuditNoChanger implements AuditManager {
    @Override
    public void performPrePersistLogic(Auditable auditable) {

    }

    @Override
    public void performPreUpdateLogic(Auditable auditable) {

    }
}
