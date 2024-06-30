package dev.saidul.EcomOrderService.dto;

import dev.saidul.EcomOrderService.enitty.PaymentDetails;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResponseDTO {
    private String status;
    private String transactionId;

    public static PaymentResponseDTO from(PaymentDetails paymentDetails){
        PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();
        paymentResponseDTO.status = String.valueOf(paymentDetails.getPaymentStatus());
        paymentResponseDTO.transactionId = paymentDetails.getTransactionId();
        return paymentResponseDTO;
    }
}
