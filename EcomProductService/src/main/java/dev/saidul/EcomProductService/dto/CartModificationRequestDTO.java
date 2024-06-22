package dev.saidul.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CartModificationRequestDTO {
    private UUID cartId;
    private UUID productId;
    private String action;
    private int quantity;
}
