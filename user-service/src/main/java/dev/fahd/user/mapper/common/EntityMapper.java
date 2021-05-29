package dev.fahd.user.mapper.common;

import java.util.List;

public interface EntityMapper<E,D> {

    E toEntity(D dto);

    D toDTO(E entity);

    List<E> toEntity(List<D> dtos);

    List<D> toDTO(List<E> entities);
}
