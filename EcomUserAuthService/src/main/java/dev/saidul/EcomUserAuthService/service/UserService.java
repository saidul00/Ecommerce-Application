package dev.saidul.EcomUserAuthService.service;

import dev.saidul.EcomUserAuthService.dto.UserDTO;
import dev.saidul.EcomUserAuthService.dto.UserRolesRequestDTO;

import java.util.UUID;

public interface UserService {
    UserDTO getUserDetails(String email);
    UserDTO setUserRoles(UserRolesRequestDTO requestDTO);

}
