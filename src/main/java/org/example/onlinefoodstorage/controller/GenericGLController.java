package org.example.onlinefoodstorage.controller;


import jakarta.validation.Valid;
import org.example.onlinefoodstorage.criteria.BaseCriteria;
import org.example.onlinefoodstorage.dto.GenericDTO;
import org.example.onlinefoodstorage.response.Data;
import org.example.onlinefoodstorage.util.APIUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;
import java.util.List;

public interface GenericGLController<GD extends GenericDTO, CR extends BaseCriteria, K extends Serializable> {
    @RequestMapping(value = APIUtils.GET_PATH, method = RequestMethod.GET)
    ResponseEntity<Data<GD>> get(@PathVariable K id);

    @RequestMapping(value = APIUtils.LIST_PATH, method = RequestMethod.GET)
    ResponseEntity<Data<List<GD>>> getAll(@Valid CR criteria);
}
