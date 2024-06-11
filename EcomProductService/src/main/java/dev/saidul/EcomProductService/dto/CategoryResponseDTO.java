package dev.saidul.EcomProductService.dto;

import dev.saidul.EcomProductService.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseDTO {
    private String name;
    public static CategoryResponseDTO from(Category category){
        CategoryResponseDTO responseDTO = new CategoryResponseDTO();
        responseDTO.setName(category.getTitle());
        return responseDTO;
    }
}
