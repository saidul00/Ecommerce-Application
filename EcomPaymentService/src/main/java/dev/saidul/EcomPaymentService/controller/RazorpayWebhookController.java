package dev.saidul.EcomPaymentService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RazorpayWebhookController {
    @PostMapping("/webhook/razorpay")
    public ResponseEntity<String> razorPayWebhook(){
        return ResponseEntity.ok(
                "OK"
        );
    }
}
