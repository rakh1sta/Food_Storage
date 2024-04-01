package org.example.onlinefoodstorage.repository.auth;

import org.example.onlinefoodstorage.entity.auth.Auth;
import org.example.onlinefoodstorage.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long>, BaseRepository {

    Optional<Auth> findByPhone(String phone);
    Optional<Auth> findByPhoneAndPassword(String phone,String password);
    boolean existsAuthsByPhone(String phone);

}
