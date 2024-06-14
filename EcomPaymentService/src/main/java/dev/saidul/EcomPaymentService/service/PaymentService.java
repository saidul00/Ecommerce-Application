package dev.saidul.EcomPaymentService.service;

import com.razorpay.RazorpayException;
import dev.saidul.EcomPaymentService.dto.PaymentRequestDTO;

public interface PaymentService {
    String generatePaymentLink(PaymentRequestDTO paymentRequestDTO) throws RazorpayException;
}
