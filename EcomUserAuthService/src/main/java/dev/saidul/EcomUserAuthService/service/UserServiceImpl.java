package dev.saidul.EcomUserAuthService.service;

import dev.saidul.EcomUserAuthService.dto.UserDTO;
import dev.saidul.EcomUserAuthService.dto.UserRolesRequestDTO;
import dev.saidul.EcomUserAuthService.entity.Role;
import dev.saidul.EcomUserAuthService.entity.User;
import dev.saidul.EcomUserAuthService.exception.RoleNotFoundException;
import dev.saidul.EcomUserAuthService.exception.UserNotFoundException;
import dev.saidul.EcomUserAuthService.repository.RoleRepository;
import dev.saidul.EcomUserAuthService.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    public UserServiceImpl(UserRepository userRepository,RoleRepository roleRepository){
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
    }

    public UserDTO getUserDetails(UUID userId){
        User savedUser = userRepository.findById(userId).orElseThrow(
                ()-> new UserNotFoundException("User not found")
        );
        return UserDTO.from(savedUser);
    }

    public UserDTO setUserRoles(UserRolesRequestDTO requestDTO){
        Role role = roleRepository.findById(requestDTO.getRoleId()).orElseThrow(
                () -> new RoleNotFoundException("Role not found")
        );
        User user = userRepository.findById(requestDTO.getUserId()).orElseThrow(
                () -> new UserNotFoundException("User not found")
        );

        List<Role> roles = Optional.ofNullable(user.getRoles()).orElseGet(ArrayList::new);
        roles.add(role);
        user.setRoles(roles);

        User updatedUser = userRepository.save(user);

        return UserDTO.from(updatedUser);
    }
}
