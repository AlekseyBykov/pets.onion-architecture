package alekseybykov.portfolio.whitepappers.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aleksey Bykov
 * @since 08.09.2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "WhitepapperItemDto: identifier and name of whitepapper")
public class WhitepapperItemDto {

    @ApiModelProperty("Identifier of whitepapper")
    private Long id;

    @ApiModelProperty("Name of whitepapper")
    private String name;
}
