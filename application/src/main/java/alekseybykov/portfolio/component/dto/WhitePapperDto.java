package alekseybykov.portfolio.component.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "WhitePapperDto: DTO for exchange with a client")
public class WhitePapperDto {

    @ApiModelProperty("WhitePapper id")
    private Long id;

    @ApiModelProperty("WhitePapper name")
    private String name;

    @ApiModelProperty("WhitePapper creation date")
    private ZonedDateTime dateCreate;
}
