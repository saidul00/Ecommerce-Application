package dev.saidul.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductCreationDTO {
    private String title;
    private double price;
    private String description;
    private UUID categoryId;
    private String imageURL;
}
