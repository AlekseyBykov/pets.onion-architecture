//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.mappings;

import alekseybykov.portfolio.component.dto.ScreenDocumentDto;
import alekseybykov.portfolio.component.entities.User;
import alekseybykov.portfolio.component.entities.WhitePapper;
import alekseybykov.portfolio.component.entities.WhitePapperMetadata;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import static java.util.Objects.nonNull;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ScreenDocumentMapper extends BaseMapper<WhitePapper, ScreenDocumentDto> {

    @Mappings({
            @Mapping(source = "whitePapper.whitePapperMetadata", target = "userCreate", qualifiedByName = "userCreateToDto"),
            @Mapping(source = "whitePapper.audit.dateCreate", target = "dateCreate"),
            @Mapping(source = "whitePapper.whitePapperMetadata", target = "whitePapperMetadata")
    })
    ScreenDocumentDto toDto(WhitePapper whitePapper);

    @Named("userCreateToDto")
    default User userCreateToDto(WhitePapperMetadata metadata) {
        if (nonNull(metadata) && nonNull(metadata.getAudit())) {
            return nonNull(metadata.getAudit().getUserUpdate()) ?
                    metadata.getAudit().getUserUpdate() :
                    metadata.getAudit().getUserCreate();
        } else {
            return null;
        }
    }
}
