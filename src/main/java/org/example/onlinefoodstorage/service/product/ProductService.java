package org.example.onlinefoodstorage.service.product;

import org.example.onlinefoodstorage.criteria.GenericCriteria;
import org.example.onlinefoodstorage.dto.product.ProductCreDTO;
import org.example.onlinefoodstorage.dto.product.ProductResDTO;
import org.example.onlinefoodstorage.dto.product.ProductUptDTO;
import org.example.onlinefoodstorage.service.GenericCUDService;
import org.example.onlinefoodstorage.service.GenericGLService;

public interface ProductService extends GenericCUDService<ProductCreDTO, ProductUptDTO, ProductResDTO, Long>,
        GenericGLService<ProductResDTO, GenericCriteria, Long> {
}
