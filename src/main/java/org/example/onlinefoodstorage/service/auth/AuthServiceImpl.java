package org.example.onlinefoodstorage.service.auth;

//import org.example.onlinefoodstorage.config.encryption.PasswordEncoderConfigurer;

import org.example.onlinefoodstorage.config.jwt.JwtTokenProvider;
import org.example.onlinefoodstorage.criteria.GenericCriteria;
import org.example.onlinefoodstorage.dto.auth.AuthCreDTO;
import org.example.onlinefoodstorage.dto.auth.AuthResDTO;
import org.example.onlinefoodstorage.dto.auth.AuthUptDTO;
import org.example.onlinefoodstorage.dto.auth.LoginReqDTO;
import org.example.onlinefoodstorage.entity.auth.Auth;
import org.example.onlinefoodstorage.enums.auth.UserRole;
import org.example.onlinefoodstorage.enums.auth.UserStatus;
import org.example.onlinefoodstorage.exceptions.customExceptions.AlreadyExistException;
import org.example.onlinefoodstorage.exceptions.customExceptions.BadCredentialException;
import org.example.onlinefoodstorage.exceptions.customExceptions.NotFoundException;
import org.example.onlinefoodstorage.mapper.auth.AuthMapper;
import org.example.onlinefoodstorage.repository.auth.AuthRepository;
import org.example.onlinefoodstorage.service.AbstractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl extends AbstractService<AuthMapper, AuthRepository>
        implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;


    public AuthServiceImpl(AuthMapper mapper, AuthRepository repository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        super(mapper, repository);
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String registerUser(AuthCreDTO dto) {
        if (!dto.getPassword().equals(dto.getRepeatPassword()))
            throw new BadCredentialException("Password not equals to repeated password");
        Optional<Auth> auth = repository.findByPhone(dto.getPhone());
        if (auth.isPresent())
            throw new AlreadyExistException("Auth already exist with given phone :" + auth.get().getPhone());
        Auth entity = mapper.toEntity(dto);
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.setStatus(UserStatus.ACTIVE);
        entity = repository.save(entity);
        return jwtTokenProvider.generateToken(entity);
    }

    @Override
    public AuthResDTO create(AuthCreDTO dto) {
        return null;
    }

    @Override
    public AuthResDTO update(AuthUptDTO dto) {
        repository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException("Auth not found"));
        Auth entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public Boolean delete(Long id) {
        Auth auth = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Auth not found by id : " + id));
        auth.setDeleted(true);
        repository.save(auth);
        return true;
    }

    @Override
    public AuthResDTO get(Long id) {
        Auth auth = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Auth not found by id : " + id));
        return mapper.toDto(auth);
    }

    @Override
    public List<AuthResDTO> getAll(GenericCriteria criteria) {
        Pageable request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort());
        Page<Auth> entities = repository.findAll(request);
        return entities.stream().map(mapper::toDto).toList();
    }

    public String login(LoginReqDTO dto) {
        Auth userNotFound = repository.findByPhone(dto.getPhone()).orElseThrow(() -> new NotFoundException("User not found"));
        boolean matches = passwordEncoder.matches(dto.getPassword(), userNotFound.getPassword());
        if (matches) {
            return jwtTokenProvider.generateToken(userNotFound);
        }
        return null;
    }
}
