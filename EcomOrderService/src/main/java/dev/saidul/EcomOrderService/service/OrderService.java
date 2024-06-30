package dev.saidul.EcomOrderService.service;

import dev.saidul.EcomOrderService.dto.CheckoutConfirmRequestDTO;
import dev.saidul.EcomOrderService.dto.NewOrderRequestDTO;
import dev.saidul.EcomOrderService.dto.OrderResponseDTO;
import dev.saidul.EcomOrderService.dto.UpdateOrderStatusDTO;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    OrderResponseDTO checkout(NewOrderRequestDTO newOrderRequestDTO);
    OrderResponseDTO confirmCheckout(UUID userId, CheckoutConfirmRequestDTO checkoutConfirmRequestDTO);
    OrderResponseDTO getOrderById(UUID orderId);
    List<OrderResponseDTO> getAllOrderForUser(UUID userId);
    OrderResponseDTO updateOrderStatus(UUID orderId, UpdateOrderStatusDTO updateOrderStatusDTO);
    OrderResponseDTO cancelOrder(UUID orderId);
}
