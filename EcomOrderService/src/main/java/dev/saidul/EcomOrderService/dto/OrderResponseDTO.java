package dev.saidul.EcomOrderService.dto;

import dev.saidul.EcomOrderService.enitty.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderResponseDTO {
    private UUID orderId;
    private UUID userId;
    private double total;
    private List<OrderItemDTO> items;
    private String status;
    private ShippingAddressDTO address;
    private PaymentResponseDTO paymentDetails;

    public static OrderResponseDTO from(Order order){
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.userId = order.getUserId();
        orderResponseDTO.orderId = order.getId();
        if(!order.getOrderItems().isEmpty()){
            orderResponseDTO.items = order.getOrderItems().stream()
                    .map(OrderItemDTO::from).toList();
        }
        orderResponseDTO.status = String.valueOf(order.getOrderStatus());
        if(order.getPaymentDetails()!= null){
            orderResponseDTO.paymentDetails = PaymentResponseDTO.from(order.getPaymentDetails());
        }
        if(order.getShippingDetails()!=null){
            orderResponseDTO.address = ShippingAddressDTO.from(order.getShippingDetails());
        }
        return orderResponseDTO;
    }

}
