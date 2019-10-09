//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.mappings;

import alekseybykov.portfolio.whitepappers.dto.WhitepapperMetadataDto;
import alekseybykov.portfolio.whitepappers.entities.WhitepapperMetadata;
import org.mapstruct.Mapper;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-08
 */
@Mapper(componentModel = "spring")
public interface WhitepapperMapper extends BaseMapper<WhitepapperMetadata, WhitepapperMetadataDto> { }
