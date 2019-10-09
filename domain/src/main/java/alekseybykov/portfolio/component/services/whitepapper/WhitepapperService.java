//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.services.whitepapper;

import alekseybykov.portfolio.component.entities.FileTransferObject;
import alekseybykov.portfolio.component.entities.Whitepapper;
import alekseybykov.portfolio.component.entities.WhitepapperMetadata;
import lombok.NonNull;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-08
 */
public interface WhitepapperService {

    Long upload(@NonNull FileTransferObject fileTransferObject,
                @NonNull WhitepapperMetadata whitepapperMetadata) throws IOException;

    Page<Whitepapper> findAllWhitepappers(Integer page, Integer size);

    void deleteByIds(List<Long> ids);

    Whitepapper getById(@NonNull Long id);
}
