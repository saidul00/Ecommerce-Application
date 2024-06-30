package dev.saidul.EcomOrderService.controller;

import dev.saidul.EcomOrderService.dto.CheckoutConfirmRequestDTO;
import dev.saidul.EcomOrderService.dto.NewOrderRequestDTO;
import dev.saidul.EcomOrderService.dto.OrderResponseDTO;
import dev.saidul.EcomOrderService.dto.UpdateOrderStatusDTO;
import dev.saidul.EcomOrderService.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private OrderController(OrderService orderService){
        this.orderService = orderService;
    }
    @PostMapping("/checkout")
    public ResponseEntity<OrderResponseDTO> checkout(@PathVariable NewOrderRequestDTO newOrderRequestDTO){
        OrderResponseDTO responseDTO = orderService.checkout(newOrderRequestDTO);
        return ResponseEntity.ok(
                responseDTO
        );
    }

    @PostMapping("/{userId}/confirm")
    public ResponseEntity<OrderResponseDTO> confirmCheckout(@PathVariable("userId")UUID userId,
                                                            @PathVariable CheckoutConfirmRequestDTO checkoutConfirmRequestDTO){
        OrderResponseDTO responseDTO = orderService.confirmCheckout(userId, checkoutConfirmRequestDTO);
        return ResponseEntity.ok(
                responseDTO
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable("id")UUID oderId){
        OrderResponseDTO responseDTO = orderService.getOrderById(oderId);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/user/{userid})")
    public ResponseEntity<List<OrderResponseDTO>> getAllOrderForUser(@PathVariable("userid") UUID userId){
        List<OrderResponseDTO> responseDTOS = orderService.getAllOrderForUser(userId);
        return ResponseEntity.ok(
                responseDTOS
        );
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<OrderResponseDTO> updateOrderStatus(@PathVariable("orderId") UUID orderId,
                                                              @RequestBody UpdateOrderStatusDTO updateOrderStatusDTO){
        OrderResponseDTO responseDTO = orderService.updateOrderStatus(orderId, updateOrderStatusDTO);
        return ResponseEntity.ok(
                responseDTO
        );
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> cancelOrder(@PathVariable("orderId") UUID orderId){
        OrderResponseDTO responseDTO = orderService.cancelOrder(orderId);
        return ResponseEntity.ok(responseDTO);
    }
}
