package org.example.onlinefoodstorage.dto.auth;

import lombok.Getter;
import lombok.Setter;
import org.example.onlinefoodstorage.dto.GenericDTO;

@Getter
@Setter
public class AuthUptDTO extends GenericDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private String oldPassword;
    private String newPassword;
    private String repeatNewPassword;
}
