package dev.saidul.EcomProductService.security;

import dev.saidul.EcomProductService.security.dto.ValidateTokenRequestDTO;
import dev.saidul.EcomProductService.security.dto.ValidateTokenResponseDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;


@Component
public class AuthenticationClient {
    private final RestTemplateBuilder restTemplateBuilder;
    public AuthenticationClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

    public ValidateTokenResponseDTO validate(String token, UUID userId){
        RestTemplate restTemplate = restTemplateBuilder.build();

        ValidateTokenRequestDTO tokenRequestDTO = new ValidateTokenRequestDTO();
        tokenRequestDTO.setToken(token);
        tokenRequestDTO.setUserId(userId);

        ResponseEntity<ValidateTokenResponseDTO> response = restTemplate.postForEntity(
                "http://localhost:8080/auth/validate",
                tokenRequestDTO,
                ValidateTokenResponseDTO.class
        );
        return response.getBody();
    }

}
