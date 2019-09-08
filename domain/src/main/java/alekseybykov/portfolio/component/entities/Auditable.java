package alekseybykov.portfolio.component.entities;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-08
 */
public interface Auditable {

    Audit getAudit();

    void setAudit(Audit audit);
}
