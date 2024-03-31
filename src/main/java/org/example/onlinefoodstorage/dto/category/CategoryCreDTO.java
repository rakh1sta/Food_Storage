package org.example.onlinefoodstorage.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.onlinefoodstorage.dto.BaseDTO;
import org.example.onlinefoodstorage.enums.category.CategoryStatus;

@Getter
@Setter
public class CategoryCreDTO implements BaseDTO {
    @NotBlank(message = "name can not be blank")
    @NotNull(message = "name can not be null")
    @Size(min = 3, max = 120, message = "name length can not be less than 3")
    private String name;

    @NotBlank(message = "Type can not be blank")
    @NotNull(message = "Type can not be null")
    @Size(min = 3, max = 120, message = "Type length can not be less than 3")
    private String type;

    @NotNull(message = "Status can not be null")
    private CategoryStatus status;
}
