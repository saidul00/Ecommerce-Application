package dev.saidul.EcomOrderService.dto;

import dev.saidul.EcomOrderService.enitty.ShippingDetails;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShippingAddressDTO {
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String country;

    public static ShippingAddressDTO from(ShippingDetails shippingDetails){
        ShippingAddressDTO addressDTO = new ShippingAddressDTO();
        addressDTO.address = shippingDetails.getAddress();
        addressDTO.city = shippingDetails.getCity();
        addressDTO.state = shippingDetails.getState();
        addressDTO.zipcode = shippingDetails.getZipcode();
        addressDTO.country = shippingDetails.getCountry();

        return addressDTO;
    }
}
