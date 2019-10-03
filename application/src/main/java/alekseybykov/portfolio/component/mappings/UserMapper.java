//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.mappings;

import alekseybykov.portfolio.component.dto.UserDto;
import alekseybykov.portfolio.component.entities.User;
import org.mapstruct.Mapper;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto>  { }
