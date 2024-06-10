package dev.saidul.EcomUserAuthService.service;

import dev.saidul.EcomUserAuthService.dto.UserLoginRequestDTO;
import dev.saidul.EcomUserAuthService.dto.UserResponseDTO;
import dev.saidul.EcomUserAuthService.dto.UserSignupRequestDTO;

public interface UserService {
    UserResponseDTO signup(UserSignupRequestDTO signupRequestDTO);
    UserResponseDTO login(UserLoginRequestDTO loginRequestDTO);
}
