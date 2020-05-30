package alekseybykov.portfolio.whitepappers.registries;

import alekseybykov.portfolio.whitepappers.entities.Audit;

/**
 * @author Aleksey Bykov
 * @since 24.09.2019
 */
public interface AuditRegistry {
    Audit findAudit(String entityName, Long entityId);
}
