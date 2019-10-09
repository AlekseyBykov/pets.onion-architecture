//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.mappings;

import alekseybykov.portfolio.whitepappers.dto.UserDto;
import alekseybykov.portfolio.whitepappers.entities.User;
import org.mapstruct.Mapper;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto>  { }
