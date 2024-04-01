package org.example.onlinefoodstorage.service.category;

import org.example.onlinefoodstorage.config.redis.CacheNames;
import org.example.onlinefoodstorage.criteria.GenericCriteria;
import org.example.onlinefoodstorage.dto.category.CategoryCreDTO;
import org.example.onlinefoodstorage.dto.category.CategoryResDTO;
import org.example.onlinefoodstorage.dto.category.CategoryUptDTO;
import org.example.onlinefoodstorage.entity.category.Category;
import org.example.onlinefoodstorage.exceptions.customExceptions.AlreadyExistException;
import org.example.onlinefoodstorage.exceptions.customExceptions.NotFoundException;
import org.example.onlinefoodstorage.mapper.category.CategoryMapper;
import org.example.onlinefoodstorage.repository.category.CategoryRepository;
import org.example.onlinefoodstorage.service.AbstractService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = CacheNames.OTHER_ENTRY)
public class CategoryServiceImpl extends AbstractService<CategoryMapper, CategoryRepository> implements CategoryService {

    public CategoryServiceImpl(CategoryMapper mapper, CategoryRepository repository) {
        super(mapper, repository);
    }

//    @Cacheable(key = "#result.id")
    @Override
    public CategoryResDTO create(CategoryCreDTO dto) {
        System.out.println("create Request to the db");

        Optional<Category> category = repository.findByName(dto.getName());
        if (category.isPresent())
            throw new AlreadyExistException("Category already exist with given name :" + category.get().getName());
        Category entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

//    @CachePut(key = "#dto.id")
    @Override
    public CategoryResDTO update(CategoryUptDTO dto) {
        System.out.println("update Request to the db");

        repository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException("Category not found"));
        Category entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

//    @CacheEvict(key = "#id")
    @Override
    public Boolean delete(Long id) {
        System.out.println("delete Request to the db");
        Category category = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found by id : " + id));
        category.setDeleted(true);
        repository.save(category);
        return true;
    }

    @Cacheable(key = "#id")
    @Override
    public CategoryResDTO get(Long id) {
        System.out.println("get Request to the db");
        Category category = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found by id : " + id));
        return mapper.toDto(category);
    }

//    @Cacheable(CacheNames.OTHER_ENTRY)
    @Override
    public List<CategoryResDTO> getAll(GenericCriteria criteria) {
        Pageable request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort());
        Page<Category> entities = repository.findAll(request);
        return entities.stream().map(mapper::toDto).toList();
    }
}
