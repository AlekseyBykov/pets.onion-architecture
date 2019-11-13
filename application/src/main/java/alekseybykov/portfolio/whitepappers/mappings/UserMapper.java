package alekseybykov.portfolio.whitepappers.mappings;

import alekseybykov.portfolio.whitepappers.dto.UserDto;
import alekseybykov.portfolio.whitepappers.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto>  { }
