package dev.saidul.EcomUserAuthService.service;

import dev.saidul.EcomUserAuthService.dto.*;
import dev.saidul.EcomUserAuthService.entity.User;
import dev.saidul.EcomUserAuthService.exception.UserAlreadyExistException;
import dev.saidul.EcomUserAuthService.exception.UserNotFoundException;
import dev.saidul.EcomUserAuthService.repository.SessionRepository;
import dev.saidul.EcomUserAuthService.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, SessionRepository sessionRepository,
                           PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public UserDTO signup(UserSignupRequestDTO signupRequestDTO){
        Optional<User> userOptional = userRepository.findByEmail(signupRequestDTO.getEmail());
        if(userOptional.isPresent()){
            throw new UserAlreadyExistException("User with email: "+signupRequestDTO.getEmail()+" already exist.");
        }
        User user = new User();
        user.setName(signupRequestDTO.getName());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhone(signupRequestDTO.getPhone());
        user.setPassword(passwordEncoder.encode(signupRequestDTO.getPassword()));

        User savedUser = userRepository.save(user);

        return UserDTO.from(savedUser);
    }

    public UserDTO login(UserLoginRequestDTO loginRequestDTO){
        Optional<User> userOptional = userRepository.findByEmail(loginRequestDTO.getEmail());
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found for email:"+loginRequestDTO.getEmail());
        }

        return UserDTO.from(userOptional.get());
    }

}
