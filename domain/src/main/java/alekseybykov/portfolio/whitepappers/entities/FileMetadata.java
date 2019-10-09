//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.entities;

import lombok.*;

import javax.persistence.*;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"whitepapper", "audit"})
@ToString(exclude = {"whitepapper", "audit"})
@Table(name = "file_metadata")
public class FileMetadata implements Auditable {

    public enum Storage {
        LOCAL,
        MINIO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "storage")
    @Enumerated(EnumType.STRING)
    private Storage storage;

    @Embedded
    private Audit audit;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "white_papper_id", referencedColumnName = "id")
    private Whitepapper whitepapper;
}
