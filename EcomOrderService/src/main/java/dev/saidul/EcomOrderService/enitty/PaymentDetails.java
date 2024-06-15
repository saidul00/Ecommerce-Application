package dev.saidul.EcomOrderService.enitty;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class PaymentDetails extends BaseModel{
    private UUID orderId;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private String paymentId;
    private String transactionId;
    private LocalDateTime paymentDate;
}
