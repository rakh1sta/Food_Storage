package org.example.onlinefoodstorage.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.onlinefoodstorage.dto.BaseDTO;
import org.example.onlinefoodstorage.enums.auth.UserRole;

@Getter
@Setter
public class AuthCreDTO implements BaseDTO {
    @NotBlank(message = "first name can not be blank")
    @NotNull(message = "first name can not be null")
    @Size(min = 3, max = 120, message = "first name length can not be less than 3")
    private String firstName;

    @NotBlank(message = "last name can not be blank")
    @NotNull(message = "last name can not be null")
    @Size(min = 3, max = 120, message = "last name length can not be less than 3")
    private String lastName;

    @NotBlank(message = "phone number can not be blank")
    @NotNull(message = "phone number name can not be null")
//    @Pattern(regexp = "^\\+998\\d{2}\\d{7}$\n", message = "phone number is wrong")
    private String phone;

    @NotBlank(message = "password can not be blank")
    @NotNull(message = "password can not be null")
    @Size(min = 3, max = 10, message = "password length can not be less than 3")
    private String password;

    @NotBlank(message = "repeat password can not be blank")
    @NotNull(message = "repeat password can not be null")
    @Size(min = 3, max = 10, message = "repeat password length can not be less than 3")
    private String repeatPassword;

    @NotNull(message = "role can not be null")
    private UserRole role;
}
