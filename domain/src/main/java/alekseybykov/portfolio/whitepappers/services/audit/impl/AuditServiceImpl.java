package alekseybykov.portfolio.whitepappers.services.audit.impl;

import alekseybykov.portfolio.whitepappers.entities.Audit;
import alekseybykov.portfolio.whitepappers.registries.AuditRegistry;
import alekseybykov.portfolio.whitepappers.services.audit.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Aleksey Bykov
 * @since 24.09.2019
 */
@Service
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {

    private final AuditRegistry auditRegistry;

    @Override
    public Audit getAudit(String entityName, Long entityId) {
        return auditRegistry.findAudit(entityName, entityId);
    }
}
