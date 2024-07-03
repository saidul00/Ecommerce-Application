package dev.saidul.EcomUserAuthService.service;

import dev.saidul.EcomUserAuthService.config.JwtUtil;
import dev.saidul.EcomUserAuthService.dto.UserDTO;
import dev.saidul.EcomUserAuthService.dto.UserLoginRequestDTO;
import dev.saidul.EcomUserAuthService.dto.UserSignupRequestDTO;
import dev.saidul.EcomUserAuthService.dto.ValidateTokenRequestDTO;
import dev.saidul.EcomUserAuthService.entity.Session;
import dev.saidul.EcomUserAuthService.entity.SessionStatus;
import dev.saidul.EcomUserAuthService.entity.User;
import dev.saidul.EcomUserAuthService.exception.InvalidCredentialsException;
import dev.saidul.EcomUserAuthService.exception.UserAlreadyExistException;
import dev.saidul.EcomUserAuthService.exception.UserNotFoundException;
import dev.saidul.EcomUserAuthService.repository.SessionRepository;
import dev.saidul.EcomUserAuthService.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMapAdapter;

import java.util.HashMap;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    private final JwtUtil jwtUtil;
    public AuthServiceImpl(UserRepository userRepository, SessionRepository sessionRepository,
                           JwtUtil jwtUtil){
        this.userRepository=userRepository;
        this.passwordEncoder=new BCryptPasswordEncoder();
        this.sessionRepository=sessionRepository;
        this.jwtUtil=jwtUtil;
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

    public ResponseEntity<UserDTO> login(UserLoginRequestDTO loginRequestDTO){
        Optional<User> userOptional = userRepository.findByEmail(loginRequestDTO.getEmail());
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found for email:"+loginRequestDTO.getEmail());
        }
        User user = userOptional.get();
        if(!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())){
            throw new InvalidCredentialsException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getId().toString());

        MultiValueMapAdapter<String,String> headers = new MultiValueMapAdapter<>(new HashMap<>());
        headers.add("AUTH_TOKEN", token);

        Session session = new Session();
        session.setSessionStatus(SessionStatus.ACTIVE);
        session.setToken(token);
        session.setUser(user);
        sessionRepository.save(session);

        UserDTO userDTO = UserDTO.from(user);
        return new ResponseEntity<>(
                userDTO,
                headers,
                HttpStatus.OK
        );
    }

    public SessionStatus validate(ValidateTokenRequestDTO validateTokenRequestDTO){
        Optional<Session> sessionOptional = sessionRepository.findByTokenAndUserId(validateTokenRequestDTO.getToken(),
                validateTokenRequestDTO.getUserId());

        if(sessionOptional.isEmpty()){
            return SessionStatus.INVALID;
        }

        Session session = sessionOptional.get();
        if(!session.getSessionStatus().equals(SessionStatus.ACTIVE)){
            return SessionStatus.EXPIRED;
        }

        return SessionStatus.ACTIVE;
    }
}
