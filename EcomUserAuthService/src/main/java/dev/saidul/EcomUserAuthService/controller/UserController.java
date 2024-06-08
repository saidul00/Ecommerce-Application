package dev.saidul.EcomUserAuthService.controller;

import dev.saidul.EcomUserAuthService.dto.UserResponseDTO;
import dev.saidul.EcomUserAuthService.dto.UserSignupRequestDTO;
import dev.saidul.EcomUserAuthService.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> signup(@RequestBody UserSignupRequestDTO signupRequestDTO){
        return null;
    }
}
