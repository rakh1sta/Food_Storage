package org.example.onlinefoodstorage.controller.category;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.onlinefoodstorage.controller.AbstractController;
import org.example.onlinefoodstorage.criteria.GenericCriteria;
import org.example.onlinefoodstorage.dto.category.CategoryCreDTO;
import org.example.onlinefoodstorage.dto.category.CategoryResDTO;
import org.example.onlinefoodstorage.dto.category.CategoryUptDTO;
import org.example.onlinefoodstorage.response.Data;
import org.example.onlinefoodstorage.service.category.CategoryServiceImpl;
import org.example.onlinefoodstorage.util.APIUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = APIUtils.PATH + "/category")
@Tag(name = "Category Controller")
public class CategoryControllerImpl extends AbstractController<CategoryServiceImpl> implements CategoryController {
    public CategoryControllerImpl(CategoryServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<CategoryResDTO>> create(CategoryCreDTO DTO) {
        CategoryResDTO categoryResDTO = service.create(DTO);
        return new ResponseEntity<>(new Data<>(categoryResDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CategoryResDTO>> update(CategoryUptDTO DTO) {
        CategoryResDTO update = service.update(DTO);
        return new ResponseEntity<>(new Data<>(update), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(Long id) {
        Boolean delete = service.delete(id);
        return new ResponseEntity<>(new Data<>(delete), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CategoryResDTO>> get(Long id) {
        CategoryResDTO categoryResDTO = service.get(id);
        return new ResponseEntity<>(new Data<>(categoryResDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<CategoryResDTO>>> getAll(GenericCriteria criteria) {
        List<CategoryResDTO> all = service.getAll(criteria);
        return new ResponseEntity<>(new Data<>(all, all.size()), HttpStatus.OK);
    }
}
