package org.example.onlinefoodstorage.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.onlinefoodstorage.dto.BaseDTO;
import org.example.onlinefoodstorage.enums.product.ProductStatus;

@Getter
@Setter
public class ProductCreDTO implements BaseDTO {
    @NotBlank(message = "name can not be blank")
    @NotNull(message = "name can not be null")
    @Size(min = 3, max = 120, message = "name length can not be less than 3")
    private String name;

    @NotNull(message = "Status can not be null")
    private ProductStatus status;

    @Size(message = "Amount can not be less than zero")
    private Long amount;

    @Size(message = "Amount can not be less than zero")
    private Long storagePeriodDay;
}
