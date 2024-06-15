package dev.saidul.EcomOrderService.enitty;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class ShippingDetails extends BaseModel {
    private UUID orderId;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String country;
    private LocalDateTime shippingDate;
    private LocalDateTime deliveryDate;
}
