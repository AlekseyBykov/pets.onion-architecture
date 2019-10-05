package alekseybykov.portfolio.component.mappings;

import alekseybykov.portfolio.component.dto.ScopeDto;
import alekseybykov.portfolio.component.entities.Scope;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScopeMapper extends BaseMapper<Scope, ScopeDto> { }
