package alekseybykov.portfolio.whitepappers.services.whitepapper;

import alekseybykov.portfolio.whitepappers.entities.FileTransferObject;
import alekseybykov.portfolio.whitepappers.entities.Whitepapper;
import alekseybykov.portfolio.whitepappers.entities.WhitepapperMetadata;
import lombok.NonNull;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

/**
 * @author Aleksey Bykov
 * @since 08.09.2019
 */
public interface WhitepapperService {

    Long upload(@NonNull FileTransferObject fileTransferObject,
                @NonNull WhitepapperMetadata whitepapperMetadata) throws IOException;

    Page<Whitepapper> findAllWhitepappers(Integer page, Integer size);

    void deleteByIds(List<Long> ids);

    Whitepapper getById(@NonNull Long id);
}
