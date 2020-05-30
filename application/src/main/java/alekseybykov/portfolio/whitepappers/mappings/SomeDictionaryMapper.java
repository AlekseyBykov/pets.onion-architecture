package alekseybykov.portfolio.whitepappers.mappings;

import alekseybykov.portfolio.whitepappers.dto.SomeDictionaryDto;
import alekseybykov.portfolio.whitepappers.entities.SomeDictionary;
import org.mapstruct.Mapper;

/**
 * @author Aleksey Bykov
 * @since 09.10.2019
 */
@Mapper(componentModel = "spring")
public interface SomeDictionaryMapper extends BaseMapper<SomeDictionary, SomeDictionaryDto> { }
