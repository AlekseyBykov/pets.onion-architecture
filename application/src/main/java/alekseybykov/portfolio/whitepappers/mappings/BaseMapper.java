package alekseybykov.portfolio.whitepappers.mappings;

import java.util.List;

/**
 * @author Aleksey Bykov
 * @since 08.09.2019
 */
public interface BaseMapper<E, D> {

    List<D> toListDto(List<E> entityList);

    D toDto(E entity);

    E toEntity(D dto);
}
