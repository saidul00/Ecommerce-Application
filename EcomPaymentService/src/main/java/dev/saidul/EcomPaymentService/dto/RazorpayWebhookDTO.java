package dev.saidul.EcomPaymentService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class RazorpayWebhookDTO {
    private String entity;
    private String account_id;
    private String event;
    private String[] contains;
    private PaymentEntity payment;
    private long created_at;

    @Getter
    @Setter
    public static class PaymentEntity {
        private String id;
        private String entity;
        private int amount;
        private String currency;
        private String status;
        private String order_id;
        private String invoice_id;
        private boolean international;
        private String method;
        private int amount_refunded;
        private String refund_status;
        private boolean captured;
        private String description;
        private String card_id;
        private Card card;
        private String bank;
        private String wallet;
        private String vpa;
        private String email;
        private String contact;
        private Map<String, String> notes;
        private Integer fee;
        private Integer tax;
        private String error_code;
        private String error_description;
        private String error_source;
        private String error_step;
        private String error_reason;
        private AcquirerData acquirer_data;
        private long created_at;
        private String reward;
    }

    @Getter
    @Setter
    public static class Card {
        private String id;
        private String entity;
        private String name;
        private String last4;
        private String network;
        private String type;
        private String issuer;
        private boolean international;
        private boolean emi;
        private String sub_type;
        private String token_iin;
    }

    @Getter
    @Setter
    public static class AcquirerData {
        private String auth_code;
    }
}
