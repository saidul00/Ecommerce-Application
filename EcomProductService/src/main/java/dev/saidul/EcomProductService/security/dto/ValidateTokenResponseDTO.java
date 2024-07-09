package dev.saidul.EcomProductService.security.dto;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ValidateTokenResponseDTO {
    private UserDTO userDTO;
    private SessionStatus sessionStatus;
}
