package dev.saidul.EcomOrderService.service;

import dev.saidul.EcomOrderService.dto.*;
import dev.saidul.EcomOrderService.enitty.Order;
import dev.saidul.EcomOrderService.enitty.OrderItem;
import dev.saidul.EcomOrderService.enitty.OrderStatus;
import dev.saidul.EcomOrderService.exception.InvalidOrderException;
import dev.saidul.EcomOrderService.exception.OrderNotFoundException;
import dev.saidul.EcomOrderService.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }

    @Override
    public OrderResponseDTO checkout(NewOrderRequestDTO newOrderRequestDTO) {
        Order order = new Order();
        order.setUserId(newOrderRequestDTO.getUserId());
        List<OrderItem> items = newOrderRequestDTO.getItems().stream()
                .map(OrderItemDTO::from).toList();
        order.setOrderItems(items);
        order.setTotalAmount(newOrderRequestDTO.getTotal());
        order.setOrderStatus(OrderStatus.PENDING);

        Order savedOrder = orderRepository.save(order);
        return OrderResponseDTO.from(savedOrder);
    }

    @Override
    public OrderResponseDTO confirmCheckout(UUID userId, CheckoutConfirmRequestDTO checkoutConfirmRequestDTO) {
        return null;
    }

    @Override
    public OrderResponseDTO getOrderById(UUID orderId) {
        Order savedOrder = orderRepository.findById(orderId).orElseThrow(
                ()-> new InvalidOrderException("Order not found")
        );
        return OrderResponseDTO.from(savedOrder);
    }

    @Override
    public List<OrderResponseDTO> getAllOrderForUser(UUID userId) {
        List<Order> orderList = orderRepository.findAllByUserId(userId).orElseThrow(
                ()-> new OrderNotFoundException("Not found")
        );
        return orderList.stream().
                map(OrderResponseDTO::from).toList();
    }

    @Override
    public OrderResponseDTO updateOrderStatus(UUID orderId, UpdateOrderStatusDTO updateOrderStatusDTO) {
        Order savedOrder = orderRepository.findById(orderId).orElseThrow(
                ()-> new OrderNotFoundException("Order not found")
        );
        OrderStatus orderStatus = OrderStatus.valueOf(updateOrderStatusDTO.getNewStatus());

        switch (orderStatus){
            case PENDING, SHIPPED, CONFIRMED, DELIVERED -> savedOrder.setOrderStatus(orderStatus);
            default -> throw new IllegalArgumentException("Unexpected order status: "+orderStatus);
        }

        Order updatedOrder = orderRepository.save(savedOrder);
        return OrderResponseDTO.from(updatedOrder);
    }

    @Override
    public OrderResponseDTO cancelOrder(UUID orderId) {
        Order savedOrder = orderRepository.findById(orderId).orElseThrow(
                ()-> new OrderNotFoundException("Order not found")
        );
        savedOrder.setOrderStatus(OrderStatus.CANCELLED);
        //todo: send item back to inventory, refund, cancel shipping

        Order upatedOrder = orderRepository.save(savedOrder);
        return OrderResponseDTO.from(upatedOrder);
    }
}
