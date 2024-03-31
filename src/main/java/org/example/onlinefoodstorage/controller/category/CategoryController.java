package org.example.onlinefoodstorage.controller.category;


import org.example.onlinefoodstorage.controller.GenericCUDController;
import org.example.onlinefoodstorage.controller.GenericGLController;
import org.example.onlinefoodstorage.criteria.GenericCriteria;
import org.example.onlinefoodstorage.dto.category.CategoryCreDTO;
import org.example.onlinefoodstorage.dto.category.CategoryResDTO;
import org.example.onlinefoodstorage.dto.category.CategoryUptDTO;

public interface CategoryController extends GenericCUDController<CategoryCreDTO, CategoryUptDTO, CategoryResDTO,Long>,
        GenericGLController<CategoryResDTO, GenericCriteria, Long>{
}
