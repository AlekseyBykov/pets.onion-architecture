package alekseybykov.portfolio.whitepappers.audit;

import alekseybykov.portfolio.whitepappers.entities.User;
import alekseybykov.portfolio.whitepappers.service.user.SecurityService;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Aleksey Bykov
 * @since 03.10.2019
 */
@Component
public class AuditInterceptor  extends EmptyInterceptor {

    private SecurityService securityService;
    private Auditor auditor;

    private ThreadLocal<User> localUser = new ThreadLocal<>();

    @Lazy
    public AuditInterceptor(SecurityService securityService, Auditor auditIntegrator) {
        super();
        this.securityService = securityService;
        this.auditor = auditIntegrator;
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        auditor.embedAuditBeforeCreating(entity, id, state, propertyNames, localUser.get());
        return super.onSave(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        auditor.embedAuditBeforeChanging(entity, id, currentState, previousState, propertyNames, localUser.get());
        return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
    }

    @Override
    public void afterTransactionBegin(Transaction tx) {
        localUser.set(securityService.getCurrentUser());
        super.afterTransactionBegin(tx);
    }
}
