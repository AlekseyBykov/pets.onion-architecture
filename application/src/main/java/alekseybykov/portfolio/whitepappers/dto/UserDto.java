package alekseybykov.portfolio.whitepappers.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
