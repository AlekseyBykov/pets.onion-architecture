//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.entities;

import alekseybykov.portfolio.component.listeners.AuditListener;
import lombok.*;

import javax.persistence.*;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-08
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"audit"})
@ToString(exclude = {"audit"})
@Table(name = "white_papper_metadata")
@EntityListeners(AuditListener.class)
public class WhitePapperMetadata implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "registration_number")
    private String registrationNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "white_papper_id")
    private WhitePapper whitePapper;

    @Embedded
    private Audit audit;
}
