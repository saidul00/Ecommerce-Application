package dev.saidul.EcomUserAuthService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserRolesRequestDTO {
    private UUID userId;
    private UUID roleId;
}
