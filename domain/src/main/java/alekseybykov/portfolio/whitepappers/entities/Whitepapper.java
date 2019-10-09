//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.entities;

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
@EqualsAndHashCode(exclude = {"audit", "whitepapperMetadata"})
@ToString(exclude = {"audit", "whitepapperMetadata"})
@Table(name = "white_papper")
//@EntityListeners(AuditListener.class)
public class Whitepapper implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Embedded
    private Audit audit;

    @OneToOne(mappedBy = "whitepapper", cascade = CascadeType.ALL)
    private WhitepapperMetadata whitepapperMetadata;
}
