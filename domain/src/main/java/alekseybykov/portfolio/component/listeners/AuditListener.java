package alekseybykov.portfolio.component.listeners;

import alekseybykov.portfolio.component.audit.AuditManager;
import alekseybykov.portfolio.component.entities.Auditable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-23
 */
@Component
public class AuditListener {

    private static AuditManager auditManager;

    @Autowired
    public void setAuditManager(AuditManager auditManager) {
        this.auditManager = auditManager;
    }

    @PrePersist
    public void setCreatedOn(Auditable auditable) {
        auditManager.performPrePersistLogic(auditable);
    }

    @PreUpdate
    public void setUpdatedOn(Auditable auditable) {
        auditManager.performPreUpdateLogic(auditable);
    }
}
