package dev.saidul.EcomProductService.controller;

import dev.saidul.EcomProductService.dto.CartCreationDTO;
import dev.saidul.EcomProductService.dto.CartModificationRequestDTO;
import dev.saidul.EcomProductService.dto.CartResponseDTO;
import dev.saidul.EcomProductService.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;
    public CartController(CartService cartService){
        this.cartService=cartService;
    }
    @PostMapping("/add")
    public ResponseEntity<CartResponseDTO> addToCart(CartCreationDTO cartCreationDTO){
        CartResponseDTO cartResponseDTO = cartService.addToCart(cartCreationDTO);
        return ResponseEntity.ok(
                cartResponseDTO
        );
    }

    @PostMapping("/update")
    public ResponseEntity<CartResponseDTO> updateCart(CartModificationRequestDTO cartModificationRequestDTO){
        CartResponseDTO cartResponseDTO = cartService.updateCart(cartModificationRequestDTO);
        return ResponseEntity.ok(
                cartResponseDTO
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CartResponseDTO> getCartByUserId(@PathVariable("id")UUID userId){
        CartResponseDTO cartResponseDTO = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(
                cartResponseDTO
        );
    }

}
