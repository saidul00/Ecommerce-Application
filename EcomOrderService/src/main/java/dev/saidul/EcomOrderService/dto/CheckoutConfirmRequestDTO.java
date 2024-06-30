package dev.saidul.EcomOrderService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CheckoutConfirmRequestDTO {
    private UUID orderId;
    private ShippingAddressDTO shippingDetails;
    private PaymentDTO paymentDetails;
}
