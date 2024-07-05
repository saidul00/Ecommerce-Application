package dev.saidul.EcomUserAuthService.security.service;

import dev.saidul.EcomUserAuthService.entity.User;
import dev.saidul.EcomUserAuthService.repository.UserRepository;
import dev.saidul.EcomUserAuthService.security.model.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(username);

        if(userOptional.isEmpty()){
            throw new UsernameNotFoundException(username+"doesn't exist");
        }
        return new CustomUserDetails(userOptional.get());
    }
}
