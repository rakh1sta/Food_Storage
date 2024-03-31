package org.example.onlinefoodstorage.mapper.auth;

import org.example.onlinefoodstorage.dto.auth.AuthCreDTO;
import org.example.onlinefoodstorage.dto.auth.AuthResDTO;
import org.example.onlinefoodstorage.dto.auth.AuthUptDTO;
import org.example.onlinefoodstorage.entity.auth.Auth;
import org.example.onlinefoodstorage.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthMapper extends GenericMapper<AuthCreDTO, AuthUptDTO, AuthResDTO, Auth> {
}
