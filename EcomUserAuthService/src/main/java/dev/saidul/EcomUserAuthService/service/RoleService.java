package dev.saidul.EcomUserAuthService.service;

import dev.saidul.EcomUserAuthService.dto.CreateRoleRequestDTO;
import dev.saidul.EcomUserAuthService.dto.RoleResponseDTO;
import dev.saidul.EcomUserAuthService.exception.RoleAlreadyExistException;

public interface RoleService {
    RoleResponseDTO createRole(CreateRoleRequestDTO requestDTO) throws RoleAlreadyExistException;
}
