package dev.saidul.EcomUserAuthService.service;

import dev.saidul.EcomUserAuthService.dto.UserResponseDTO;
import dev.saidul.EcomUserAuthService.dto.UserSignupRequestDTO;
import dev.saidul.EcomUserAuthService.entity.User;
import dev.saidul.EcomUserAuthService.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public UserResponseDTO signup(UserSignupRequestDTO signupRequestDTO) {
        User user = new User();
        user.setName(signupRequestDTO.getName());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhone(signupRequestDTO.getPhone());
        user.setPassword(signupRequestDTO.getPassword());
        userRepository.save(user);
        return null;
    }
}
