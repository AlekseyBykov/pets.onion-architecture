package alekseybykov.portfolio.component.entities;

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
@EqualsAndHashCode(exclude = {"audit", "whitePapperMetadata"})
@ToString(exclude = {"audit", "whitePapperMetadata"})
@Table(name = "white_papper")
public class WhitePapper implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Embedded
    private Audit audit;

    @OneToOne(mappedBy = "whitePapper", cascade = CascadeType.ALL)
    private WhitePapperMetadata whitePapperMetadata;
}
