package alekseybykov.portfolio.whitepappers.entities;

/**
 * @author Aleksey Bykov
 * @since 08.09.2019
 */
public interface Auditable {

    Long getId();

    Audit getAudit();

    void setAudit(Audit audit);
}
