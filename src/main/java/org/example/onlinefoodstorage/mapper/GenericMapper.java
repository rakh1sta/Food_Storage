package org.example.onlinefoodstorage.mapper;

import org.example.onlinefoodstorage.dto.BaseDTO;
import org.example.onlinefoodstorage.dto.GenericDTO;
import org.example.onlinefoodstorage.entity.BaseEntity;

import java.util.List;

public interface GenericMapper<
        CD extends BaseDTO,
        UD extends GenericDTO,
        D extends GenericDTO,
        E extends BaseEntity> extends BaseMapper {

    E toEntity(CD createDto);

    E toEntity(UD updateDto);

    D toDto(E entity);

    List<D> toDto(List<E> entity);

    List<E> toEntity(List<D> entity);
}
