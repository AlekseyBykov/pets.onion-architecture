package alekseybykov.portfolio.whitepappers.mappings;

import alekseybykov.portfolio.whitepappers.dto.UserDto;
import alekseybykov.portfolio.whitepappers.entities.User;
import org.mapstruct.Mapper;

/**
 * @author Aleksey Bykov
 * @since 03.10.2019
 */
@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto>  { }
