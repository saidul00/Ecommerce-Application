package dev.saidul.EcomPaymentService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PaymentRequestDTO {
    private long amount;
    private UUID oderId;
    private UUID customerId;
    private String description;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
}
