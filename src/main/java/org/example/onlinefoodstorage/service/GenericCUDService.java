package org.example.onlinefoodstorage.service;

import org.example.onlinefoodstorage.dto.BaseDTO;
import org.example.onlinefoodstorage.dto.GenericDTO;

import java.io.Serializable;

public interface GenericCUDService<CD extends BaseDTO, UD extends GenericDTO,D extends GenericDTO, K extends Serializable> {
    D create(CD dto);

    D update(UD dto);

    Boolean delete(K id);
}
