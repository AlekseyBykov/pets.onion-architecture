package alekseybykov.portfolio.whitepappers.entities;

public interface Auditable {

    Long getId();

    Audit getAudit();

    void setAudit(Audit audit);
}
