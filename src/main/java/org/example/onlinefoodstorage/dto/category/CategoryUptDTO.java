package org.example.onlinefoodstorage.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.onlinefoodstorage.dto.GenericDTO;
import org.example.onlinefoodstorage.enums.category.CategoryStatus;

@Getter
@Setter
public class CategoryUptDTO extends GenericDTO {
    private String name;
    private String type;
    private CategoryStatus status;
}
