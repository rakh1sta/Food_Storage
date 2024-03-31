package org.example.onlinefoodstorage.service.auth;

import org.example.onlinefoodstorage.config.encryption.PasswordEncoderConfigurer;
import org.example.onlinefoodstorage.criteria.GenericCriteria;
import org.example.onlinefoodstorage.dto.auth.AuthCreDTO;
import org.example.onlinefoodstorage.dto.auth.AuthResDTO;
import org.example.onlinefoodstorage.dto.auth.AuthUptDTO;
import org.example.onlinefoodstorage.entity.auth.Auth;
import org.example.onlinefoodstorage.enums.auth.UserRole;
import org.example.onlinefoodstorage.exceptions.customExceptions.AlreadyExistException;
import org.example.onlinefoodstorage.exceptions.customExceptions.BadCredentialException;
import org.example.onlinefoodstorage.exceptions.customExceptions.NotFoundException;
import org.example.onlinefoodstorage.mapper.auth.AuthMapper;
import org.example.onlinefoodstorage.repository.auth.AuthRepository;
import org.example.onlinefoodstorage.service.AbstractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl extends AbstractService<AuthMapper, AuthRepository>
        implements AuthService {
    private final PasswordEncoderConfigurer encoderConfigurer;

    public AuthServiceImpl(AuthMapper mapper, AuthRepository repository, PasswordEncoderConfigurer encoderConfigurer) {
        super(mapper, repository);
        this.encoderConfigurer = encoderConfigurer;
    }

    @Override
    public AuthResDTO create(AuthCreDTO dto) {
        if (!dto.getPassword().equals(dto.getRepeatPassword()))
            throw new BadCredentialException("Password not equals to repeated password");
        Optional<Auth> auth = repository.findByPhoneAndDeletedFalse(dto.getPhone());
        if (auth.isPresent())
            throw new AlreadyExistException("Auth already exist with given phone :" + auth.get().getPhone());
        Auth entity = mapper.toEntity(dto);
        entity.setRole(UserRole.USER);
        entity.setPassword(encoderConfigurer.encoder());
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public AuthResDTO update(AuthUptDTO dto) {
        repository.findByIdAndDeletedFalse(dto.getId())
                .orElseThrow(() -> new NotFoundException("Auth not found"));
        Auth entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public Boolean delete(Long id) {
        Auth auth = repository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("Auth not found by id : " + id));
        auth.setDeleted(true);
        repository.save(auth);
        return true;
    }

    @Override
    public AuthResDTO get(Long id) {
        Auth auth = repository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("Auth not found by id : " + id));
        return mapper.toDto(auth);
    }

    @Override
    public List<AuthResDTO> getAll(GenericCriteria criteria) {
        Pageable request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort());
        Page<Auth> entities = repository.findAllByDeletedFalse(request);
        return entities.stream().map(mapper::toDto).toList();
    }
}
