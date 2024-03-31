package org.example.onlinefoodstorage.entity.category;

import jakarta.persistence.*;
import lombok.*;
import org.example.onlinefoodstorage.entity.Auditable;
import org.example.onlinefoodstorage.entity.product.Product;
import org.example.onlinefoodstorage.enums.category.CategoryStatus;

import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends Auditable {
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CategoryStatus status;

    @OneToMany(fetch = FetchType.LAZY,mappedBy="category")
    private Set<Product> products;
}
