//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.mappings;

import alekseybykov.portfolio.component.dto.WhitePapperDto;
import alekseybykov.portfolio.component.entities.WhitePapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-08
 */
@Mapper(componentModel = "spring")
public interface WhitePapperMapper extends BaseMapper<WhitePapper, WhitePapperDto> {

    @Mapping(source = "audit.dateCreate", target = "dateCreate")
    WhitePapperDto toDto(WhitePapper whitePapper);

    @Mapping(source = "dateCreate", target = "audit.dateCreate")
    WhitePapper toEntity(WhitePapperDto whitePapperDto);
}
