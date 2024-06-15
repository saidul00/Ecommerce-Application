package dev.saidul.EcomOrderService.enitty;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Order extends BaseModel{
    private UUID userId;
    @OneToMany
    private List<OrderItem> orderItems;
    private double totalAmount;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @OneToOne
    private PaymentDetails paymentDetails;
    @OneToOne
    private ShippingDetails shippingDetails;
}
