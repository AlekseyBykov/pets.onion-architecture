//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.mappings;

import alekseybykov.portfolio.component.dto.ScreenDocumentDto;
import alekseybykov.portfolio.component.entities.User;
import alekseybykov.portfolio.component.entities.Whitepapper;
import alekseybykov.portfolio.component.entities.WhitepapperMetadata;
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
public interface ScreenDocumentMapper extends BaseMapper<Whitepapper, ScreenDocumentDto> {

    @Mappings({
            @Mapping(source = "whitepapper.whitepapperMetadata", target = "userCreate", qualifiedByName = "userCreateToDto"),
            @Mapping(source = "whitepapper.audit.dateCreate", target = "dateCreate"),
            @Mapping(source = "whitepapper.whitepapperMetadata", target = "whitepapperMetadata")
    })
    ScreenDocumentDto toDto(Whitepapper whitepapper);

    @Named("userCreateToDto")
    default User userCreateToDto(WhitepapperMetadata metadata) {
        if (nonNull(metadata) && nonNull(metadata.getAudit())) {
            return nonNull(metadata.getAudit().getUserUpdate()) ?
                    metadata.getAudit().getUserUpdate() :
                    metadata.getAudit().getUserCreate();
        } else {
            return null;
        }
    }
}
