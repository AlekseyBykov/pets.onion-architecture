//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.services.whitepapper.impl;

import alekseybykov.portfolio.whitepappers.entities.Audit;
import alekseybykov.portfolio.whitepappers.entities.FileTransferObject;
import alekseybykov.portfolio.whitepappers.entities.Whitepapper;
import alekseybykov.portfolio.whitepappers.entities.WhitepapperMetadata;
import alekseybykov.portfolio.whitepappers.enums.Errors;
import alekseybykov.portfolio.whitepappers.exceptions.EntityNotFoundException;
import alekseybykov.portfolio.whitepappers.registries.WhitepapperRegistry;
import alekseybykov.portfolio.whitepappers.services.file.FilesService;
import alekseybykov.portfolio.whitepappers.services.validator.Action;
import alekseybykov.portfolio.whitepappers.services.validator.WhitepapperMetadataValidator;
import alekseybykov.portfolio.whitepappers.services.whitepapper.WhitepapperService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.List;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-08
 */
@Service
@RequiredArgsConstructor
public class WhitepapperServiceImpl implements WhitepapperService {

    private final WhitepapperRegistry whitepapperRegistry;
    private final WhitepapperMetadataValidator whitepapperMetadataValidator;
    private final FilesService filesService;

    @Override
    public Long upload(@NonNull FileTransferObject fileTransferObject,
                       @NonNull WhitepapperMetadata whitepapperMetadata) {

        whitepapperMetadataValidator.validate(whitepapperMetadata, Action.CREATE);

        InputStream stream = fileTransferObject.getStream();
        String fileName = fileTransferObject.getFileName();

        Whitepapper whitepapper = Whitepapper.builder()
                .name(fileName)
                .whitepapperMetadata(whitepapperMetadata)
                .build();
        whitepapperMetadata.setWhitepapper(whitepapper);

        Whitepapper createdWhitepapper = whitepapperRegistry.save(whitepapper);

        filesService.saveFile(fileName, whitepapper, stream);

        return createdWhitepapper.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Whitepapper> findAllWhitepappers(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, new Sort(Sort.Direction.DESC, Audit.DATE_CREATE));
        return whitepapperRegistry.findAllWhitepappers(pageable);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        whitepapperRegistry.deleteByIds(ids);
    }

    @Override
    @Transactional(readOnly = true)
    public Whitepapper getById(@NonNull Long id) {
        return whitepapperRegistry.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Errors.WHITEPAPPER_NOT_FOUND.getName()));
    }
}
