package alekseybykov.portfolio.whitepappers.audit.impl;

import alekseybykov.portfolio.whitepappers.audit.AuditManager;
import alekseybykov.portfolio.whitepappers.entities.Auditable;
import lombok.RequiredArgsConstructor;

/**
 * @author Aleksey Bykov
 * @since 24.09.2019
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
