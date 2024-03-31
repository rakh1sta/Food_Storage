package org.example.onlinefoodstorage.entity.product;

import jakarta.persistence.*;
import lombok.*;
import org.example.onlinefoodstorage.entity.Auditable;
import org.example.onlinefoodstorage.entity.category.Category;
import org.example.onlinefoodstorage.enums.product.ProductStatus;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends Auditable {
    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ProductStatus status;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "storagePeriodDay")
    private Long storagePeriodDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

}
