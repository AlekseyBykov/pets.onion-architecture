//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.controllers;

import alekseybykov.portfolio.component.dto.ScopeDto;
import alekseybykov.portfolio.component.mappings.ScopeMapper;
import alekseybykov.portfolio.component.services.scope.ScopeService;
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
@RequestMapping("/scope")
@Api(tags = "scope", description = "Controller for working with some dictionary [e.g, for displaying items in combo]")
public class ScopeController {

    private final ScopeService scopeService;
    private final ScopeMapper scopeMapper;

    @GetMapping()
    @ApiOperation(value = "Get all the scopes")
    public List<ScopeDto> getLegalActScope() {
        return scopeMapper.toListDto(scopeService.findAll());
    }
}
