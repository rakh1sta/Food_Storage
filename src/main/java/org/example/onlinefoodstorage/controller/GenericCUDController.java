package org.example.onlinefoodstorage.controller;

import jakarta.validation.Valid;
import org.example.onlinefoodstorage.dto.BaseDTO;
import org.example.onlinefoodstorage.dto.GenericDTO;
import org.example.onlinefoodstorage.response.Data;
import org.example.onlinefoodstorage.util.APIUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public interface GenericCUDController<CD extends BaseDTO, UD extends GenericDTO, D extends GenericDTO, K extends Serializable> {
    @PostMapping(value = APIUtils.CREATE_PATH)
    ResponseEntity<Data<D>> create(@Valid @RequestBody CD DTO);

    @PutMapping(value = APIUtils.UPDATE_PATH)
    ResponseEntity<Data<D>> update(@Valid @RequestBody UD DTO);

    @DeleteMapping(value = APIUtils.DELETE_PATH)
    ResponseEntity<Data<Boolean>> delete(@PathVariable K id);
}
