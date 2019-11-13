package alekseybykov.portfolio.whitepappers.mappings;

import java.util.List;

public interface BaseMapper<E, D> {

    List<D> toListDto(List<E> entityList);

    D toDto(E entity);

    E toEntity(D dto);
}
