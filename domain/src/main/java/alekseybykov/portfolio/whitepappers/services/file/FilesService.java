//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.services.file;

import alekseybykov.portfolio.whitepappers.entities.Whitepapper;

import java.io.InputStream;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
public interface FilesService {

    void saveFile(String fileName, Whitepapper whitepapper, InputStream stream);

    Integer moveAllFilesToTheCloud();
}
