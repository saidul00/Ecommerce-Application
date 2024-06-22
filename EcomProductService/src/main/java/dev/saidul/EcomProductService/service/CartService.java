package dev.saidul.EcomProductService.service;

import dev.saidul.EcomProductService.dto.CartCreationDTO;
import dev.saidul.EcomProductService.dto.CartResponseDTO;
import dev.saidul.EcomProductService.dto.CartModificationRequestDTO;

import java.util.UUID;

public interface CartService {
    CartResponseDTO addToCart(CartCreationDTO cartCreationDTO);
    CartResponseDTO getCartByUserId(UUID userId);
    CartResponseDTO updateCart(CartModificationRequestDTO updateRequestDTO);
}
