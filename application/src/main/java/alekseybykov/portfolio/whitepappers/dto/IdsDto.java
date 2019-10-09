//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "IdsDto: Identifier's list")
public class IdsDto {

    @ApiModelProperty("Identifier's list")
    @Singular
    private List<Long> ids;
}
