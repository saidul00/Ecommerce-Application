package dev.saidul.EcomProductService.service;

import dev.saidul.EcomProductService.dto.ProductCreationDTO;
import dev.saidul.EcomProductService.dto.ProductResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductResponseDTO createProduct(ProductCreationDTO productCreationDTO);
    ProductResponseDTO getProductById(UUID id);
    List<ProductResponseDTO> getAllProduct();
}
