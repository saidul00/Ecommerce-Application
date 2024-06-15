package dev.saidul.EcomOrderService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OrderItemDTO {
    private UUID productId;
    private int quantity;
    private double price;
}
