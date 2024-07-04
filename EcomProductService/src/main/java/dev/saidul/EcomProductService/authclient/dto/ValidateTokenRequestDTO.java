package dev.saidul.EcomProductService.authclient.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ValidateTokenRequestDTO {
    private UUID userId;
    private String token;
}
