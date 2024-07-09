package dev.saidul.EcomUserAuthService.service;

import dev.saidul.EcomUserAuthService.dto.*;
import dev.saidul.EcomUserAuthService.entity.SessionStatus;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    UserDTO signup(UserSignupRequestDTO signupRequestDTO);
    UserDTO login(UserLoginRequestDTO loginRequestDTO);
}
