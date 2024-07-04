package dev.saidul.EcomUserAuthService.dto;

import dev.saidul.EcomUserAuthService.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RoleResponseDTO {
    private UUID id;
    private String role;
    
    public static RoleResponseDTO from(Role role){
        if (role==null) return null;
        RoleResponseDTO responseDTO = new RoleResponseDTO();
        responseDTO.id=role.getId();
        responseDTO.role=role.getRoleName();
        return responseDTO;
    }
}
