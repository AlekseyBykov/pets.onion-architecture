//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.controllers;

import alekseybykov.portfolio.component.dto.IdsDto;
import alekseybykov.portfolio.component.dto.WhitePapperDto;
import alekseybykov.portfolio.component.entities.WhitePapper;
import alekseybykov.portfolio.component.mappings.WhitePapperMapper;
import alekseybykov.portfolio.component.services.whitepapper.WhitePapperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-08-25
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/white-pappers")
@Api(tags = "white pappers", description = "Controller for working with white pappers")
public class WhitePapperController {

    private final WhitePapperService whitePapperService;
    private final WhitePapperMapper whitePapperMapper;

    @PostMapping()
    @ApiOperation(value = "Deleting white pappers by dentifiers")
    public void deleteByIds(@ApiParam("list of white pappers") @RequestBody IdsDto idsDto) {
        whitePapperService.deleteByIds(idsDto.getIds());
    }

    @GetMapping("/all")
    @ApiOperation(value = "Getting all the white pappers in the system")
    public List<WhitePapperDto> findAll() {
        List<WhitePapper> data = whitePapperService.findAll();
        return whitePapperMapper.toListDto(data);
    }
}
