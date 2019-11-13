package alekseybykov.portfolio.whitepappers.mappings;

import alekseybykov.portfolio.whitepappers.dto.WhitepapperMetadataDto;
import alekseybykov.portfolio.whitepappers.entities.WhitepapperMetadata;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WhitepapperMapper extends BaseMapper<WhitepapperMetadata, WhitepapperMetadataDto> { }
