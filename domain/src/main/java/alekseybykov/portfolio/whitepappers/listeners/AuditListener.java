package alekseybykov.portfolio.whitepappers.listeners;

import alekseybykov.portfolio.whitepappers.audit.AuditManager;
import alekseybykov.portfolio.whitepappers.entities.Auditable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

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
