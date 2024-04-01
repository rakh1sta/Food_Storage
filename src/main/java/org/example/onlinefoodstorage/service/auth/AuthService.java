package org.example.onlinefoodstorage.service.auth;

import org.example.onlinefoodstorage.criteria.GenericCriteria;
import org.example.onlinefoodstorage.dto.auth.AuthCreDTO;
import org.example.onlinefoodstorage.dto.auth.AuthResDTO;
import org.example.onlinefoodstorage.dto.auth.AuthUptDTO;
import org.example.onlinefoodstorage.service.GenericCUDService;
import org.example.onlinefoodstorage.service.GenericGLService;

public interface AuthService extends GenericCUDService<AuthCreDTO, AuthUptDTO, AuthResDTO, Long>,
        GenericGLService<AuthResDTO, GenericCriteria, Long> {
    String registerUser(AuthCreDTO dto);
}
