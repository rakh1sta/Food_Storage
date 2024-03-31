package org.example.onlinefoodstorage.repository.category;

import org.example.onlinefoodstorage.entity.auth.Auth;
import org.example.onlinefoodstorage.entity.category.Category;
import org.example.onlinefoodstorage.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> , BaseRepository {
    Optional<Category> findByName(String name);
    Page<Category> findAllByDeletedFalse(Pageable pageable);
    Optional<Category> findByIdAndDeletedFalse(Long id);


}
