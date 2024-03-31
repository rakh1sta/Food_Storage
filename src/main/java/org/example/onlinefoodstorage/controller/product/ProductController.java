package org.example.onlinefoodstorage.controller.product;

import org.example.onlinefoodstorage.controller.GenericCUDController;
import org.example.onlinefoodstorage.controller.GenericGLController;
import org.example.onlinefoodstorage.criteria.GenericCriteria;
import org.example.onlinefoodstorage.dto.product.ProductCreDTO;
import org.example.onlinefoodstorage.dto.product.ProductResDTO;
import org.example.onlinefoodstorage.dto.product.ProductUptDTO;

public interface ProductController extends GenericCUDController<ProductCreDTO, ProductUptDTO, ProductResDTO, Long>,
        GenericGLController<ProductResDTO, GenericCriteria, Long> {
}
