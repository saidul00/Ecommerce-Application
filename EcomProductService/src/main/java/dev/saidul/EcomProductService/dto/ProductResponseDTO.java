package dev.saidul.EcomProductService.dto;

import dev.saidul.EcomProductService.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductResponseDTO {
    private UUID productId;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private double rating;
    public static ProductResponseDTO from(Product product){
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setProductId(product.getId());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setDescription(product.getDescription());
        //responseDTO.setCategory(CategoryResponseDTO.from(product.getCategory()).getName());
        responseDTO.setImageURL(product.getImageURL());
        return responseDTO;
    }
}
