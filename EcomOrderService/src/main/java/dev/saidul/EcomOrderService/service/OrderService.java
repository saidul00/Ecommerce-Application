package dev.saidul.EcomOrderService.service;

import dev.saidul.EcomOrderService.dto.OrderRequestDTO;
import dev.saidul.EcomOrderService.dto.OrderResponseDTO;

public interface OrderService {
    OrderResponseDTO placeOrder(OrderRequestDTO orderRequestDTO);
}
