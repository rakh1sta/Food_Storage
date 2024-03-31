package org.example.onlinefoodstorage.mapper.category;

import org.example.onlinefoodstorage.dto.category.CategoryCreDTO;
import org.example.onlinefoodstorage.dto.category.CategoryResDTO;
import org.example.onlinefoodstorage.dto.category.CategoryUptDTO;
import org.example.onlinefoodstorage.entity.category.Category;
import org.example.onlinefoodstorage.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CategoryMapper extends GenericMapper<CategoryCreDTO, CategoryUptDTO, CategoryResDTO, Category> {
}
