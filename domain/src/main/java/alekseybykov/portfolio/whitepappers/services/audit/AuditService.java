package alekseybykov.portfolio.whitepappers.services.audit;

import alekseybykov.portfolio.whitepappers.entities.Audit;

/**
 * @author Aleksey Bykov
 * @since 24.09.2019
 */
public interface AuditService {
    Audit getAudit(String entityName, Long entityId);
}
