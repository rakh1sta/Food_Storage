package org.example.onlinefoodstorage.dto.product;

import lombok.Getter;
import lombok.Setter;
import org.example.onlinefoodstorage.dto.GenericDTO;
import org.example.onlinefoodstorage.enums.product.ProductStatus;

@Getter
@Setter
public class ProductResDTO extends GenericDTO {
    private String name;
    private ProductStatus status;
    private Long amount;
    private Long storagePeriodDay;
}
