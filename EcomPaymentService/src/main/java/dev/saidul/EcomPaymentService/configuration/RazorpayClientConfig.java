package dev.saidul.EcomPaymentService.configuration;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;

@Configuration
public class RazorpayClientConfig {
    @Value("${razorpay.client.key}")
    private String razorpayClientKey;
    @Value("${razorpay.client.secret}")
    private String razorpayClientSecret;

    @Bean
    public RazorpayClient getRazorpayClient() throws RazorpayException {
        return new RazorpayClient(razorpayClientKey, razorpayClientSecret);
    }
}
