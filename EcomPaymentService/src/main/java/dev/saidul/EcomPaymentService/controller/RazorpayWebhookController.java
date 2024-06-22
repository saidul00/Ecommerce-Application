package dev.saidul.EcomPaymentService.controller;

import dev.saidul.EcomPaymentService.dto.RazorpayWebhookDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RazorpayWebhookController {
    @PostMapping("/webhook/razorpay")
    public ResponseEntity<String> razorPayWebhook(@RequestBody RazorpayWebhookDTO dto){
        System.out.println("Razorpay webhook called");
        return ResponseEntity.ok(
                "OK"
        );
    }
}
