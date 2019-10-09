//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.services.audit.impl;

import alekseybykov.portfolio.whitepappers.entities.Audit;
import alekseybykov.portfolio.whitepappers.registries.AuditRegistry;
import alekseybykov.portfolio.whitepappers.services.audit.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-24
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
