package alekseybykov.portfolio.whitepappers.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

/**
 * @author Aleksey Bykov
 * @since 03.10.2019
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
