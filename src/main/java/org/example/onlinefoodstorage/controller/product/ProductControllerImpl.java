package org.example.onlinefoodstorage.controller.product;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.onlinefoodstorage.controller.AbstractController;
import org.example.onlinefoodstorage.criteria.GenericCriteria;
import org.example.onlinefoodstorage.dto.product.ProductCreDTO;
import org.example.onlinefoodstorage.dto.product.ProductResDTO;
import org.example.onlinefoodstorage.dto.product.ProductUptDTO;
import org.example.onlinefoodstorage.response.Data;
import org.example.onlinefoodstorage.service.product.ProductServiceImpl;
import org.example.onlinefoodstorage.util.APIUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = APIUtils.PATH + "/product")
@Tag(name = "Product Controller")
public class ProductControllerImpl extends AbstractController<ProductServiceImpl> implements ProductController {

    public ProductControllerImpl(ProductServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<ProductResDTO>> create(ProductCreDTO DTO) {
        ProductResDTO categoryResDTO = service.create(DTO);
        return new ResponseEntity<>(new Data<>(categoryResDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<ProductResDTO>> update(ProductUptDTO DTO) {
        ProductResDTO categoryResDTO = service.update(DTO);
        return new ResponseEntity<>(new Data<>(categoryResDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(Long id) {
        Boolean delete = service.delete(id);
        return new ResponseEntity<>(new Data<>(delete), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<ProductResDTO>> get(Long id) {
        ProductResDTO categoryResDTO = service.get(id);
        return new ResponseEntity<>(new Data<>(categoryResDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<ProductResDTO>>> getAll(GenericCriteria criteria) {
        List<ProductResDTO> all = service.getAll(criteria);
        return new ResponseEntity<>(new Data<>(all, all.size()), HttpStatus.OK);
    }
}
