package org.example.onlinefoodstorage.dto.auth;

import lombok.Getter;
import lombok.Setter;
import org.example.onlinefoodstorage.dto.GenericDTO;
import org.example.onlinefoodstorage.enums.auth.UserStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class AuthResDTO extends GenericDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private UserStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
