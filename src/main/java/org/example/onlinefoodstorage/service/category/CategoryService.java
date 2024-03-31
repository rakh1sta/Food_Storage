package org.example.onlinefoodstorage.service.category;

import org.example.onlinefoodstorage.criteria.GenericCriteria;
import org.example.onlinefoodstorage.dto.category.CategoryCreDTO;
import org.example.onlinefoodstorage.dto.category.CategoryResDTO;
import org.example.onlinefoodstorage.dto.category.CategoryUptDTO;
import org.example.onlinefoodstorage.service.GenericCUDService;
import org.example.onlinefoodstorage.service.GenericGLService;

public interface CategoryService extends GenericCUDService<CategoryCreDTO, CategoryUptDTO,CategoryResDTO, Long>,
        GenericGLService<CategoryResDTO, GenericCriteria, Long> {
}
