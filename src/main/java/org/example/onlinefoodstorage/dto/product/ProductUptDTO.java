package org.example.onlinefoodstorage.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.onlinefoodstorage.dto.GenericDTO;
import org.example.onlinefoodstorage.enums.product.ProductStatus;

@Getter
@Setter
public class ProductUptDTO extends GenericDTO {
    private String name;
    private ProductStatus status;
    private Long amount;
    private Long storagePeriodDay;
}
