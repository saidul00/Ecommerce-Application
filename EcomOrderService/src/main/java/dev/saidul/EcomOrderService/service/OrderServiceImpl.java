package dev.saidul.EcomOrderService.service;

import dev.saidul.EcomOrderService.dto.OrderRequestDTO;
import dev.saidul.EcomOrderService.dto.OrderResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Override
    public OrderResponseDTO placeOrder(OrderRequestDTO orderRequestDTO) {
        return null;
    }
}
