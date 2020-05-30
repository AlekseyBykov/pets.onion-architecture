package alekseybykov.portfolio.whitepappers.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * @author Aleksey Bykov
 * @since 08.09.2019
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Audit {

    public static final String DATE_CREATE = "audit.dateCreate";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_user_id", referencedColumnName = "id")
    private User userCreate;

    @Column(name = "created_dt")
    private ZonedDateTime dateCreate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_user_id", referencedColumnName = "id")
    private User userUpdate;

    @Column(name = "updated_dt")
    private ZonedDateTime dateUpdate;
}
