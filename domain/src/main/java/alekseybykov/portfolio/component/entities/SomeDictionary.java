//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "some_dictionary")
public class SomeDictionary {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
