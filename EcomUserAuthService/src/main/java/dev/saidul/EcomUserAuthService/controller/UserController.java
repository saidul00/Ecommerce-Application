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

    @GetMapping("/{email}")
    public ResponseEntity<UserDTO> getUserDetails(@PathVariable("email")String email){
        UserDTO userDTO = userService.getUserDetails(email);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }


    @PostMapping("/setrole")
    public ResponseEntity<UserDTO> setUserRoles(@RequestBody UserRolesRequestDTO userRolesRequestDTO){
        UserDTO userDTO = userService.setUserRoles(userRolesRequestDTO);

        return ResponseEntity.ok(
                userDTO
        );
    }
}
