package dev.saidul.EcomPaymentService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequestDTO {
    private long amount;
    private String oderId;
    private String description;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
}
