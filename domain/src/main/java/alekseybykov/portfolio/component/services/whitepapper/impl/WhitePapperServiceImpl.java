//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.services.whitepapper.impl;

import alekseybykov.portfolio.component.entities.FileTransferObject;
import alekseybykov.portfolio.component.entities.WhitePapper;
import alekseybykov.portfolio.component.entities.WhitePapperMetadata;
import alekseybykov.portfolio.component.registries.WhitePapperRegistry;
import alekseybykov.portfolio.component.services.validator.Action;
import alekseybykov.portfolio.component.services.validator.WhitepapperMetadataValidator;
import alekseybykov.portfolio.component.services.whitepapper.WhitePapperService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-08
 */
@Service
@RequiredArgsConstructor
public class WhitePapperServiceImpl implements WhitePapperService {

    private final WhitePapperRegistry whitePapperRegistry;
    private final WhitepapperMetadataValidator whitepapperMetadataValidator;

    @Override
    public Long upload(@NonNull FileTransferObject fileTransferObject,
                       @NonNull WhitePapperMetadata whitePapperMetadata) {

        whitepapperMetadataValidator.validate(whitePapperMetadata, Action.CREATE);

        InputStream stream = fileTransferObject.getStream();
        String fileName = fileTransferObject.getFileName();

        WhitePapper whitePapper = WhitePapper.builder()
                .name(fileName)
                .whitePapperMetadata(whitePapperMetadata)
                .build();
        whitePapperMetadata.setWhitePapper(whitePapper);

        WhitePapper createdWhitePapper = whitePapperRegistry.save(whitePapper);

//        filesService.saveFile(); fixme add service

        return createdWhitePapper.getId();
    }

    @Override
    public List<WhitePapper> findAll() {
        return whitePapperRegistry.findAll();
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        whitePapperRegistry.deleteByIds(ids);
    }
}
