package org.example.onlinefoodstorage.dto.category;

import lombok.Getter;
import lombok.Setter;
import org.example.onlinefoodstorage.dto.GenericDTO;
import org.example.onlinefoodstorage.enums.category.CategoryStatus;

@Getter
@Setter
public class CategoryResDTO extends GenericDTO {
    private String name;
    private String type;
    private CategoryStatus status;
}
