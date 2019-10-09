//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "User: data about the user")
public class UserDto {
    @ApiModelProperty("Идентификатор")
    private Long id;

    @ApiModelProperty("Login of the user")
    private String login;

    @ApiModelProperty("Last name of the user")
    private String lastName;

    @ApiModelProperty("First name of the user")
    private String firstName;

    @ApiModelProperty("Middle name of the user")
    private String middleName;
}
