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

import java.time.ZonedDateTime;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "ScreenDto: data for displaying in screens")
public class ScreenDto {

    @ApiModelProperty("Identifier of the whitepapper")
    private Long id;

    @ApiModelProperty("Name of the whitepapper")
    private String name;

    @ApiModelProperty("The user who uploaded the file")
    private UserDto userCreate;

    @ApiModelProperty("Whitepapper's creation date and time")
    private ZonedDateTime dateCreate;

    @ApiModelProperty("Metadata of whitepapper")
    private WhitepapperMetadataDto whitepapperMetadata;
}
