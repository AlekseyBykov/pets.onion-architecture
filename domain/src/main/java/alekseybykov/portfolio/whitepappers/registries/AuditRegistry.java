package alekseybykov.portfolio.whitepappers.registries;

import alekseybykov.portfolio.whitepappers.entities.Audit;

public interface AuditRegistry {
    Audit findAudit(String entityName, Long entityId);
}
