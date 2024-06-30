package dev.saidul.EcomOrderService.dto;

import dev.saidul.EcomOrderService.enitty.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OrderItemDTO {
    private UUID productId;
    private int quantity;
    private double price;

    public static OrderItemDTO from(OrderItem orderItem){
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.productId = orderItem.getProductId();
        orderItemDTO.quantity = orderItem.getQuantity();
        orderItemDTO.price = orderItem.getPrice();
        return orderItemDTO;
    }

    public static OrderItem from(OrderItemDTO orderItemDTO){
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(orderItemDTO.getProductId());
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setPrice(orderItemDTO.getPrice());
        return orderItem;
    }
}
