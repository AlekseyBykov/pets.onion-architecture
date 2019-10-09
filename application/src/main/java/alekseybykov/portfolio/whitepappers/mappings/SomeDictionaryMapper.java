package alekseybykov.portfolio.whitepappers.mappings;

import alekseybykov.portfolio.whitepappers.dto.SomeDictionaryDto;
import alekseybykov.portfolio.whitepappers.entities.SomeDictionary;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SomeDictionaryMapper extends BaseMapper<SomeDictionary, SomeDictionaryDto> { }
