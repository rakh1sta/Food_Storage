package org.example.onlinefoodstorage.mapper.product;

import org.example.onlinefoodstorage.dto.product.ProductCreDTO;
import org.example.onlinefoodstorage.dto.product.ProductResDTO;
import org.example.onlinefoodstorage.dto.product.ProductUptDTO;
import org.example.onlinefoodstorage.entity.product.Product;
import org.example.onlinefoodstorage.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper extends GenericMapper<ProductCreDTO, ProductUptDTO, ProductResDTO, Product> {
}
