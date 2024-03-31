package org.example.onlinefoodstorage.service;


import org.example.onlinefoodstorage.criteria.BaseCriteria;
import org.example.onlinefoodstorage.dto.GenericDTO;

import java.io.Serializable;
import java.util.List;

public interface GenericGLService<D extends GenericDTO, C extends BaseCriteria, K extends Serializable> {
    D get(K id);

    List<D> getAll(C criteria);
}
