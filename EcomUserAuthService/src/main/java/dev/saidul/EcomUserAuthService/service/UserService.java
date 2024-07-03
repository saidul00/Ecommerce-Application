package dev.saidul.EcomUserAuthService.service;

import dev.saidul.EcomUserAuthService.dto.UserDTO;

import java.util.UUID;

public interface UserService {
    UserDTO getUserDetails(UUID userId);
    UserDTO setUserRoles(UUID userId,UUID roleId);

}
