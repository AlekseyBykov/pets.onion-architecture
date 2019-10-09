//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.controllers;

import alekseybykov.portfolio.whitepappers.dto.SomeDictionaryDto;
import alekseybykov.portfolio.whitepappers.mappings.SomeDictionaryMapper;
import alekseybykov.portfolio.whitepappers.services.dictionary.SomeDictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-05
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/some-dictionary")
@Api(tags = "some-dictionary", description = "Controller for working with some dictionary [e.g, for displaying items in combo]")
public class SomeDictionaryController {

    private final SomeDictionaryService service;
    private final SomeDictionaryMapper mapper;

    @GetMapping()
    @ApiOperation(value = "Get all the dictionary items")
    public List<SomeDictionaryDto> getAllDictionaryItems() {
        return mapper.toListDto(service.findAll());
    }
}
