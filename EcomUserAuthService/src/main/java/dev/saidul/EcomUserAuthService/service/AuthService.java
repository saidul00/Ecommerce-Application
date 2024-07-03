package dev.saidul.EcomUserAuthService.service;

import dev.saidul.EcomUserAuthService.dto.UserDTO;
import dev.saidul.EcomUserAuthService.dto.UserLoginRequestDTO;
import dev.saidul.EcomUserAuthService.dto.UserSignupRequestDTO;
import dev.saidul.EcomUserAuthService.dto.ValidateTokenRequestDTO;
import dev.saidul.EcomUserAuthService.entity.SessionStatus;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    UserDTO signup(UserSignupRequestDTO signupRequestDTO);
    ResponseEntity<UserDTO> login(UserLoginRequestDTO loginRequestDTO);
    SessionStatus validate(ValidateTokenRequestDTO validateTokenRequestDTO);
}
