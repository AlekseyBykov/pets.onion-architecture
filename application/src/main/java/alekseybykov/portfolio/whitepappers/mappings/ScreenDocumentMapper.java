package alekseybykov.portfolio.whitepappers.mappings;

import alekseybykov.portfolio.whitepappers.dto.ScreenDto;
import alekseybykov.portfolio.whitepappers.entities.User;
import alekseybykov.portfolio.whitepappers.entities.Whitepapper;
import alekseybykov.portfolio.whitepappers.entities.WhitepapperMetadata;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import static java.util.Objects.nonNull;

/**
 * @author Aleksey Bykov
 * @since 03.10.2019
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ScreenDocumentMapper extends BaseMapper<Whitepapper, ScreenDto> {

    @Mappings({
            @Mapping(source = "whitepapper.whitepapperMetadata", target = "userCreate", qualifiedByName = "userCreateToDto"),
            @Mapping(source = "whitepapper.audit.dateCreate", target = "dateCreate"),
            @Mapping(source = "whitepapper.whitepapperMetadata", target = "whitepapperMetadata")
    })
    ScreenDto toDto(Whitepapper whitepapper);

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
