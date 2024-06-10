package dev.saidul.EcomUserAuthService.dto;

import dev.saidul.EcomUserAuthService.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseDTO {
    private String name;
    private String email;
    private List<RoleResponseDTO> roles;
    private String token;

    public static UserResponseDTO from(User user){
        if(user == null) return null;
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.name=user.getName();
        responseDTO.email=user.getEmail();
        responseDTO.token= user.getToken();
        if (!user.getRoles().isEmpty()){
            List<RoleResponseDTO> roles = user.getRoles().stream()
                    .map(RoleResponseDTO::from)
                    .toList();
            responseDTO.setRoles(roles);
        }
        return responseDTO;
    }
}
