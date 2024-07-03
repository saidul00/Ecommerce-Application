package dev.saidul.EcomUserAuthService.controller;

import dev.saidul.EcomUserAuthService.dto.UserDTO;
import dev.saidul.EcomUserAuthService.dto.UserRolesRequestDTO;
import dev.saidul.EcomUserAuthService.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserDetails(@PathVariable("id")UUID userId){
        UserDTO userDTO = userService.getUserDetails(userId);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }


    @PostMapping("/{id}/roles")
    public ResponseEntity<UserDTO> setUserRoles(@PathVariable("id") UUID userId, @RequestBody UserRolesRequestDTO rolesRequestDTO){
        return null;
    }
}
