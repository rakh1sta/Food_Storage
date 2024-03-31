package org.example.onlinefoodstorage.repository.product;

import org.example.onlinefoodstorage.entity.category.Category;
import org.example.onlinefoodstorage.entity.product.Product;
import org.example.onlinefoodstorage.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>, BaseRepository {
    Page<Product> findAllByDeletedFalse(Pageable pageable);

    Optional<Product> findByNameAndDeletedFalse(String name);
    Optional<Product> findByIdAndDeletedFalse(Long id);

}
