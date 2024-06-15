package dev.saidul.EcomOrderService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShippingDetailsDTO {
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String country;
}
