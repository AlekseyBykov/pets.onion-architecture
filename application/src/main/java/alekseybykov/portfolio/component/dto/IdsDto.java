//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private List<Long> ids;
}
