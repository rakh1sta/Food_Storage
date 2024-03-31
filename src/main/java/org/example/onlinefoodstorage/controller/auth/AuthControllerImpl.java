package org.example.onlinefoodstorage.controller.auth;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.onlinefoodstorage.controller.AbstractController;
import org.example.onlinefoodstorage.criteria.GenericCriteria;
import org.example.onlinefoodstorage.dto.auth.AuthCreDTO;
import org.example.onlinefoodstorage.dto.auth.AuthResDTO;
import org.example.onlinefoodstorage.dto.auth.AuthUptDTO;
import org.example.onlinefoodstorage.response.Data;
import org.example.onlinefoodstorage.service.auth.AuthServiceImpl;
import org.example.onlinefoodstorage.util.APIUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = APIUtils.PATH + "/auth")
@Tag(name = "Auth Controller")
public class AuthControllerImpl extends AbstractController<AuthServiceImpl> implements AuthController {
    public AuthControllerImpl(AuthServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<AuthResDTO>> create(AuthCreDTO DTO) {
        AuthResDTO categoryResDTO = service.create(DTO);
        return new ResponseEntity<>(new Data<>(categoryResDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<AuthResDTO>> update(AuthUptDTO DTO) {
        AuthResDTO categoryResDTO = service.update(DTO);
        return new ResponseEntity<>(new Data<>(categoryResDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(Long id) {
        Boolean delete = service.delete(id);
        return new ResponseEntity<>(new Data<>(delete), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<AuthResDTO>> get(Long id) {
        AuthResDTO categoryResDTO = service.get(id);
        return new ResponseEntity<>(new Data<>(categoryResDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<AuthResDTO>>> getAll(GenericCriteria criteria) {
        List<AuthResDTO> all = service.getAll(criteria);
        return new ResponseEntity<>(new Data<>(all, all.size()), HttpStatus.OK);
    }
}
