package dev.saidul.EcomPaymentService.controller;

import com.razorpay.RazorpayException;
import dev.saidul.EcomPaymentService.dto.PaymentRequestDTO;
import dev.saidul.EcomPaymentService.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }


    @PostMapping
    public ResponseEntity<String> doPayment(@RequestBody PaymentRequestDTO paymentRequestDTO) throws RazorpayException {
        return ResponseEntity.ok(
                paymentService.generatePaymentLink(paymentRequestDTO)
        );
    }

    @GetMapping("/hello")
    ResponseEntity<String> hello(){
        System.out.println("LT called");
        return ResponseEntity.ok("ok");
    }
}
