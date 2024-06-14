package dev.saidul.EcomPaymentService.service;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import dev.saidul.EcomPaymentService.configuration.RazorpayClientConfig;
import dev.saidul.EcomPaymentService.dto.PaymentRequestDTO;
import dev.saidul.EcomPaymentService.repository.PaymentRepository;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final RazorpayClientConfig razorpayClientConfig;

    public PaymentServiceImpl(PaymentRepository paymentRepository, RazorpayClientConfig razorpayClientConfig) {
        this.paymentRepository = paymentRepository;
        this.razorpayClientConfig=razorpayClientConfig;
    }

    @Override
    public String generatePaymentLink(PaymentRequestDTO paymentRequestDTO) throws RazorpayException {
        RazorpayClient razorpay = razorpayClientConfig.getRazorpayClient();
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", paymentRequestDTO.getAmount());
        paymentLinkRequest.put("currency", "INR");
        paymentLinkRequest.put("accept_partial", false);
        paymentLinkRequest.put("expire_by", Instant.now().toEpochMilli() + 600000);
        paymentLinkRequest.put("reference_id", paymentRequestDTO.getOderId());
        paymentLinkRequest.put("description", paymentRequestDTO.getDescription());
        JSONObject customer = new JSONObject();
        customer.put("contact", paymentRequestDTO.getCustomerName());
        customer.put("name", paymentRequestDTO.getCustomerPhone());
        customer.put("email", paymentRequestDTO.getCustomerEmail());
        paymentLinkRequest.put("customer", customer);
        JSONObject notify = new JSONObject();
        notify.put("sms", true);
        notify.put("email", true);
        paymentLinkRequest.put("notify", notify);
        paymentLinkRequest.put("reminder_enable", true);
        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
        return payment.toString();
    }
}
