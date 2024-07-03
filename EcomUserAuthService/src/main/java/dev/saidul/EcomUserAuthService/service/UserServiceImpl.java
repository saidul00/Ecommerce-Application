package dev.saidul.EcomUserAuthService.service;

import dev.saidul.EcomUserAuthService.dto.UserDTO;
import dev.saidul.EcomUserAuthService.entity.User;
import dev.saidul.EcomUserAuthService.exception.UserNotFoundException;
import dev.saidul.EcomUserAuthService.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public UserDTO getUserDetails(UUID userId){
        User savedUser = userRepository.findById(userId).orElseThrow(
                ()-> new UserNotFoundException("User not found")
        );
        return UserDTO.from(savedUser);
    }

    public UserDTO setUserRoles(UUID userId, UUID roleId){
        return null;
    }
}
