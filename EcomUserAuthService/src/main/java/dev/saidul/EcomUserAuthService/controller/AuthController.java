package dev.saidul.EcomUserAuthService.controller;

import dev.saidul.EcomUserAuthService.dto.*;
import dev.saidul.EcomUserAuthService.entity.SessionStatus;
import dev.saidul.EcomUserAuthService.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService){
        this.authService=authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signup(@RequestBody UserSignupRequestDTO userSignupRequestDTO){
        UserDTO userDTO = authService.signup(userSignupRequestDTO);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserLoginRequestDTO userLoginRequestDTO){
        return authService.login(userLoginRequestDTO);
    }

    @PostMapping("/logout")
    public ResponseEntity<UserDTO> logout(@RequestBody UserLoginRequestDTO userLoginRequestDTO){
        return  null;
    }

    @PostMapping("/validate")
    public ResponseEntity<ValidateTokenResponseDTO> validate(@RequestBody ValidateTokenRequestDTO validateTokenRequestDTO){
        ValidateTokenResponseDTO responseDTO = authService.validate(validateTokenRequestDTO);

        if(responseDTO==null){
            ValidateTokenResponseDTO response = new ValidateTokenResponseDTO();
            response.setSessionStatus(SessionStatus.INVALID);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
