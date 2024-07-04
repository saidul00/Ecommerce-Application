package dev.saidul.EcomUserAuthService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateRoleRequestDTO {
    private String roleName;
}
