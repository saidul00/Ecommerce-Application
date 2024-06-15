package dev.saidul.EcomOrderService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequestDTO {
    private List<OrderItemDTO> items;
    private PaymentDetailsDTO paymentDetails;
    private ShippingDetailsDTO shippingDetails;
}
