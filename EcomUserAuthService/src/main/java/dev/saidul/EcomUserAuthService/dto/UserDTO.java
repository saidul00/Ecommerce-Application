package dev.saidul.EcomUserAuthService.dto;

import dev.saidul.EcomUserAuthService.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private String name;
    private String email;
    private List<RoleResponseDTO> roles;

    public static UserDTO from(User user){
        if(user == null) return null;
        UserDTO responseDTO = new UserDTO();
        responseDTO.name=user.getName();
        responseDTO.email=user.getEmail();

        if(user.getRoles()!=null){
            responseDTO.roles= user.getRoles().stream().map(RoleResponseDTO::from).toList();
        }

        return responseDTO;
    }
}
