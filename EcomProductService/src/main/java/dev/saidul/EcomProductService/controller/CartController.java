package dev.saidul.EcomProductService.controller;

import dev.saidul.EcomProductService.dto.CartCreationDTO;
import dev.saidul.EcomProductService.dto.CartResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    @PostMapping("/add")
    public ResponseEntity<CartResponseDTO> addToCart(CartCreationDTO cartCreationDTO){
        return null;
    }

}
