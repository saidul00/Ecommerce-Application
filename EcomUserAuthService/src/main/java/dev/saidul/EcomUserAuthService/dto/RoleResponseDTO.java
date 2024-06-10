package dev.saidul.EcomUserAuthService.dto;

import dev.saidul.EcomUserAuthService.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleResponseDTO {
    private String role;
    
    public static RoleResponseDTO from(Role role){
        if (role==null) return null;
        RoleResponseDTO responseDTO = new RoleResponseDTO();
        responseDTO.role=role.getRoleName();
        return responseDTO;
    }
}
