package dev.saidul.EcomOrderService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class NewOrderRequestDTO {
    private UUID userId;
    private List<OrderItemDTO> items;
    private double total;
}
