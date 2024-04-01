package org.example.onlinefoodstorage.dto.category;

import lombok.Getter;
import lombok.Setter;
import org.example.onlinefoodstorage.dto.GenericDTO;
import org.example.onlinefoodstorage.enums.category.CategoryStatus;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@RedisHash(value = "category")
public class CategoryResDTO extends GenericDTO implements Serializable {
    private String name;
    private String type;
    private CategoryStatus status;
}
