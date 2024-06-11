package dev.saidul.EcomProductService.service;

import dev.saidul.EcomProductService.dto.CategoryCreationDTO;
import dev.saidul.EcomProductService.dto.CategoryResponseDTO;

import java.util.UUID;

public interface CategoryService {
    CategoryResponseDTO createCategory(CategoryCreationDTO categoryCreationDTO);
    CategoryResponseDTO getCategoryById(UUID categoryId);
}
