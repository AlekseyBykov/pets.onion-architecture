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

import java.time.LocalDate;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "WhitePapperMetadataDto: metadata of whitepapper")
public class WhitePapperMetadataDto {

    @ApiModelProperty("Identifier of whitepapper")
    private Long id;

    @ApiModelProperty("Name of whitepapper")
    private String name;

    @ApiModelProperty("Type of whitepapper")
    private String type;

    @ApiModelProperty("Registration date of whitepapper")
    private LocalDate registrationDate;

    @ApiModelProperty("Registration number of whitepapper")
    private String registrationNumber;

    @ApiModelProperty("Scope of whitepapper")
    private ScopeDto scope;
}
