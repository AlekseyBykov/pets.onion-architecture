package alekseybykov.portfolio.component.mappings;

import java.util.List;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-08
 */
public interface BaseMapper<E, D> {

    List<D> toListDto(List<E> entityList);

    D toDto(E entity);

    E toEntity(D dto);
}
