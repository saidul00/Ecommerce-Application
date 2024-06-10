package dev.saidul.EcomUserAuthService.service;

import dev.saidul.EcomUserAuthService.dto.UserLoginRequestDTO;
import dev.saidul.EcomUserAuthService.dto.UserResponseDTO;
import dev.saidul.EcomUserAuthService.dto.UserSignupRequestDTO;
import dev.saidul.EcomUserAuthService.entity.Role;
import dev.saidul.EcomUserAuthService.entity.User;
import dev.saidul.EcomUserAuthService.exception.InvalidCredentialsException;
import dev.saidul.EcomUserAuthService.exception.RoleNotFoundException;
import dev.saidul.EcomUserAuthService.exception.UserNotFoundException;
import dev.saidul.EcomUserAuthService.repository.RoleRepository;
import dev.saidul.EcomUserAuthService.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository=userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public UserResponseDTO signup(UserSignupRequestDTO signupRequestDTO) {
        Role role = roleRepository.findById(signupRequestDTO.getRoleId()).orElseThrow(
                ()-> new RoleNotFoundException("Role not found")
        );
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setName(signupRequestDTO.getName());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhone(signupRequestDTO.getPhone());
        user.setPassword(encoder.encode(signupRequestDTO.getPassword()));
        user.setRoles(List.of(role));

        return UserResponseDTO.from(userRepository.save(user));
    }

    @Override
    public UserResponseDTO login(UserLoginRequestDTO loginRequestDTO) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User savedUser = userRepository.findByEmail(loginRequestDTO.getEmail()).orElseThrow(
                ()-> new UserNotFoundException("User not found")
        );
        if(encoder.matches(loginRequestDTO.getPassword(), savedUser.getPassword())){
            String userData = savedUser.getEmail()+savedUser.getPassword()+ LocalDateTime.now();
            String token = encoder.encode(userData);
            savedUser.setToken(token);
        }else {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        return UserResponseDTO.from(userRepository.save(savedUser));
    }
}
