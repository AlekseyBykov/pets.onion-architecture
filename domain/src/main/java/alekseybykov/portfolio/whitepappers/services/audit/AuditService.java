package alekseybykov.portfolio.whitepappers.services.audit;

import alekseybykov.portfolio.whitepappers.entities.Audit;

public interface AuditService {
    Audit getAudit(String entityName, Long entityId);
}
