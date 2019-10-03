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

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "FileUploadDto: file upload result")
public class FileUploadDto {

    @ApiModelProperty("Identifier of the uploaded file")
    private Long id;
}
