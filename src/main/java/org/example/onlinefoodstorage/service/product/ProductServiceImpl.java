package org.example.onlinefoodstorage.service.product;

import org.example.onlinefoodstorage.criteria.GenericCriteria;
import org.example.onlinefoodstorage.dto.product.ProductCreDTO;
import org.example.onlinefoodstorage.dto.product.ProductResDTO;
import org.example.onlinefoodstorage.dto.product.ProductUptDTO;
import org.example.onlinefoodstorage.entity.product.Product;
import org.example.onlinefoodstorage.exceptions.customExceptions.AlreadyExistException;
import org.example.onlinefoodstorage.exceptions.customExceptions.NotFoundException;
import org.example.onlinefoodstorage.mapper.product.ProductMapper;
import org.example.onlinefoodstorage.repository.product.ProductRepository;
import org.example.onlinefoodstorage.service.AbstractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl extends AbstractService<ProductMapper, ProductRepository>
        implements ProductService {
    public ProductServiceImpl(ProductMapper mapper, ProductRepository repository) {
        super(mapper, repository);
    }

    @Override
    public ProductResDTO create(ProductCreDTO dto) {
        Optional<Product> category = repository.findByName(dto.getName());
        if (category.isPresent())
            throw new AlreadyExistException("Product already exist with given name :" + category.get().getName());
        Product entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public ProductResDTO update(ProductUptDTO dto) {
        repository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException("Product not found"));
        Product entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public Boolean delete(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found by id : " + id));
        product.setDeleted(true);
        repository.save(product);
        return true;
    }

    @Override
    public ProductResDTO get(Long id) {
        Product category = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found by id : " + id));
        return mapper.toDto(category);
    }

    @Override
    public List<ProductResDTO> getAll(GenericCriteria criteria) {
        Pageable request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort());
        Page<Product> entities = repository.findAll(request);
        return entities.stream().map(mapper::toDto).toList();
    }
}
