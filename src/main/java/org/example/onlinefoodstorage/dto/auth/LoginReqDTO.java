package org.example.onlinefoodstorage.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginReqDTO {
    @NotBlank(message = "phone number can not be blank")
    @NotNull(message = "phone number name can not be null")
//    @Pattern(regexp = "^\\+998\\d{2}\\d{7}$", message = "phone number is wrong")
    private String phone;
    @NotBlank(message = "password number can not be blank")
    @NotNull(message = "password number name can not be null")
    private String password;
}
