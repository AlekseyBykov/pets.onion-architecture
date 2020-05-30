package alekseybykov.portfolio.whitepappers.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Aleksey Bykov
 * @since 08.09.2019
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"audit"})
@ToString(exclude = {"audit"})
@Table(name = "white_papper_metadata")
//@EntityListeners(AuditListener.class)
public class WhitepapperMetadata implements Auditable {
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

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "white_papper_id")
    private Whitepapper whitepapper;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "some_dictionary_id", referencedColumnName = "id")
    private SomeDictionary someDictionary;

    @Embedded
    private Audit audit;
}
