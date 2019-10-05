package alekseybykov.portfolio.component.mappings;

import alekseybykov.portfolio.component.dto.SomeDictionaryDto;
import alekseybykov.portfolio.component.entities.SomeDictionary;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SomeDictionaryMapper extends BaseMapper<SomeDictionary, SomeDictionaryDto> { }
