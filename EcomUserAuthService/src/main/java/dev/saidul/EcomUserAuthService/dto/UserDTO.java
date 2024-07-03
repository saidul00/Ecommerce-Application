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

    public static UserDTO from(User user){
        if(user == null) return null;
        UserDTO responseDTO = new UserDTO();
        responseDTO.name=user.getName();
        responseDTO.email=user.getEmail();

        return responseDTO;
    }
}
