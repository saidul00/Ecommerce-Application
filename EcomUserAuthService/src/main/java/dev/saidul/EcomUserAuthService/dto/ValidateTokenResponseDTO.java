package dev.saidul.EcomUserAuthService.dto;

import dev.saidul.EcomUserAuthService.entity.SessionStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateTokenResponseDTO {
    private UserDTO userDTO;
    private SessionStatus sessionStatus;
}
