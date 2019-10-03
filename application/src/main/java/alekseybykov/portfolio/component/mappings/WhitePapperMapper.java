//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.mappings;

import alekseybykov.portfolio.component.dto.WhitePapperMetadataDto;
import alekseybykov.portfolio.component.entities.WhitePapperMetadata;
import org.mapstruct.Mapper;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-08
 */
@Mapper(componentModel = "spring")
public interface WhitePapperMapper extends BaseMapper<WhitePapperMetadata, WhitePapperMetadataDto> { }
