//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.services.scope.impl;

import alekseybykov.portfolio.component.entities.Scope;
import alekseybykov.portfolio.component.enums.Errors;
import alekseybykov.portfolio.component.exceptions.EntityNotFoundException;
import alekseybykov.portfolio.component.registries.ScopeRegistry;
import alekseybykov.portfolio.component.services.scope.ScopeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-05
 */
@Service
@RequiredArgsConstructor
public class ScopeServiceImpl implements ScopeService {

    private final ScopeRegistry scopeRegistry;

    @Override
    @Transactional(readOnly = true)
    public List<Scope> findAll() {
        return scopeRegistry.findAll(sortByIdAsc());
    }

    @Override
    @Transactional(readOnly = true)
    public Scope findById(Long id) {
        return scopeRegistry.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Errors.SCOPE_NOT_FOUND.getName()));
    }

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }
}
