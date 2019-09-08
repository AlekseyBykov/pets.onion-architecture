package alekseybykov.portfolio.component.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-08
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Audit {

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
