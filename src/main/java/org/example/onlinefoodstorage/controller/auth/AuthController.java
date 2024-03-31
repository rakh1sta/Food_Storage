package org.example.onlinefoodstorage.controller.auth;

import org.example.onlinefoodstorage.controller.GenericCUDController;
import org.example.onlinefoodstorage.controller.GenericGLController;
import org.example.onlinefoodstorage.criteria.GenericCriteria;
import org.example.onlinefoodstorage.dto.auth.AuthCreDTO;
import org.example.onlinefoodstorage.dto.auth.AuthResDTO;
import org.example.onlinefoodstorage.dto.auth.AuthUptDTO;

public interface AuthController extends GenericCUDController<AuthCreDTO, AuthUptDTO, AuthResDTO,Long>,
        GenericGLController<AuthResDTO, GenericCriteria, Long> {
}
