//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileTransferObject {
    private String fileName;
    private InputStream stream;
}
