package org.example.onlinefoodstorage.service;

import lombok.RequiredArgsConstructor;
import org.example.onlinefoodstorage.mapper.BaseMapper;
import org.example.onlinefoodstorage.repository.BaseRepository;

@RequiredArgsConstructor
public abstract class AbstractService<M extends BaseMapper, R extends BaseRepository> implements BaseService {
    protected final M mapper;
    protected final R repository;
}
