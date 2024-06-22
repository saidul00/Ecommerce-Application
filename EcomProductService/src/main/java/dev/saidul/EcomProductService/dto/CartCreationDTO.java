package dev.saidul.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CartCreationDTO {
    private UUID userId;
    private UUID productId;
    private int quantity;
}
