package dev.saidul.EcomUserAuthService.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Address extends BaseModel{
    private UUID userId;
    private UUID orderId;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String country;
}
