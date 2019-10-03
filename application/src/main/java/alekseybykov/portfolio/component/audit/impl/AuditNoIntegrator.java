package alekseybykov.portfolio.component.audit.impl;

import alekseybykov.portfolio.component.UUIDValidator;
import alekseybykov.portfolio.component.audit.Auditor;
import alekseybykov.portfolio.component.audit.helper.AuditHelper;
import alekseybykov.portfolio.component.entities.Audit;
import alekseybykov.portfolio.component.entities.Auditable;
import alekseybykov.portfolio.component.entities.User;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import static java.time.ZonedDateTime.now;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.Optional.ofNullable;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-02
 */
@Component
@ConditionalOnProperty(name = "audit.enabled", havingValue = "false")
public class AuditNoIntegrator implements Auditor {

    @Override
    public void embedAuditBeforeCreating(Object entity,
                                         Serializable id,
                                         Object[] state,
                                         String[] propertyNames,
                                         User currentEmployee) {

        if (AuditHelper.isNotAuditor(entity) || (nonNull(id) && !UUIDValidator.isValidUuid(id))) {
            return;
        }

        Auditable auditable = (Auditable) entity;
        if (nonNull(auditable.getAudit())) {
            return;
        }

        Audit audit = Audit.builder()
                .dateCreate(now())
                .userCreate(currentEmployee)
                .build();

        int auditIndex = AuditHelper.getAuditPropertyIndexByName(propertyNames);

        if (auditIndex >= NumberUtils.INTEGER_ZERO) {
            state[auditIndex] = audit;
            auditable.setAudit(audit);
        }
    }

    @Override
    public void embedAuditBeforeChanging(Object entity,
                                         Serializable id,
                                         Object[] currentState,
                                         Object[] previousState,
                                         String[] propertyNames,
                                         User currentEmployee) {

        if (AuditHelper.isNotAuditor(entity) || isNull(id)) {
            return;
        }

        int auditPropertyIndex = AuditHelper.getAuditPropertyIndexByName(propertyNames);

        Auditable auditable = (Auditable) entity;
        if (auditPropertyIndex >= NumberUtils.INTEGER_ZERO) {
            Audit audit = ofNullable((Audit) previousState[auditPropertyIndex]).orElse(new Audit());

            if (isNull(audit.getUserUpdate())) {
                audit.setUserUpdate(currentEmployee);
            }

            if (isNull(audit.getDateUpdate())) {
                audit.setDateUpdate(now());
            }

            AuditHelper.embedAudit(auditable, audit, currentState, auditPropertyIndex);
        }
    }
}
