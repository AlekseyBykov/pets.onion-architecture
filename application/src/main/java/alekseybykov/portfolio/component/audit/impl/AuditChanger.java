//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.audit.impl;

import alekseybykov.portfolio.component.audit.AuditManager;
import alekseybykov.portfolio.component.entities.Audit;
import alekseybykov.portfolio.component.entities.Auditable;
import alekseybykov.portfolio.component.entities.User;
import alekseybykov.portfolio.component.services.audit.AuditService;
import alekseybykov.portfolio.component.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static java.time.ZonedDateTime.now;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-24
 */
@RequiredArgsConstructor
public class AuditChanger implements AuditManager {

    private final UserService userService;
    private final AuditService auditService;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public void performPrePersistLogic(Auditable auditable) {
        User currentUser = getCurrentUser();
        Long entityId = auditable.getId();
        Audit audit;

        if (isNull(entityId)) {
            audit = getCreatedOnAudit(currentUser);
        } else {
            audit = getUpdatedOnAudit(auditable, currentUser);
        }
        auditable.setAudit(audit);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public void performPreUpdateLogic(Auditable auditable) {
        User currentUser = getCurrentUser();
        auditable.setAudit(getUpdatedOnAudit(auditable, currentUser));
    }

    private Audit getCreatedOnAudit(User currentUser) {
        return Audit.builder()
                .userCreate(currentUser)
                .dateCreate(now())
                .build();
    }

    private Audit getUpdatedOnAudit(Auditable auditable, User currentUser) {
        Audit audit = auditService.getAudit(auditable.getClass().getName(), auditable.getId());
        audit.setUserUpdate(currentUser);
        audit.setDateUpdate(now());
        return audit;
    }

    private User getCurrentUser() {
        String userName = "admin";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (nonNull(auth)) {
            Object principal = auth.getPrincipal();
            if (principal instanceof UserDetails) {
                userName = ((UserDetails)principal).getUsername();
            }
        }
        return userService.findByLogin(userName);
    }
}
