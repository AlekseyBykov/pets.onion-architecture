package alekseybykov.portfolio.whitepappers.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Aleksey Bykov
 * @since 03.10.2019
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "some_dictionary")
public class SomeDictionary {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
