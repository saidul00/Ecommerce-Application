package dev.saidul.EcomUserAuthService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserSignupRequestDTO {
    private String name;
    private String email;
    private String phone;
    private String password;
    private UUID roleId;
}
