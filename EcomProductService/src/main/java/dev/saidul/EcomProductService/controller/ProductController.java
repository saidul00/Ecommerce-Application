package dev.saidul.EcomProductService.controller;

import dev.saidul.EcomProductService.security.AuthenticationClient;
import dev.saidul.EcomProductService.security.dto.Role;
import dev.saidul.EcomProductService.security.dto.SessionStatus;
import dev.saidul.EcomProductService.security.dto.ValidateTokenResponseDTO;
import dev.saidul.EcomProductService.dto.ProductCreationDTO;
import dev.saidul.EcomProductService.dto.ProductResponseDTO;
import dev.saidul.EcomProductService.service.ProductService;
import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final AuthenticationClient authenticationClient;
    private final ProductService productService;
    public ProductController(ProductService productService, AuthenticationClient authenticationClient){
        this.productService=productService;
        this.authenticationClient=authenticationClient;
    }


    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductCreationDTO createProductDTO){
        return ResponseEntity.ok(
                productService.createProduct(createProductDTO)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id")UUID id){
        return ResponseEntity.ok(
                productService.getProductById(id)
        );
    }


    //admin privilege required to access this API
    @GetMapping("/all")
    public ResponseEntity<List<ProductResponseDTO>> getAllProduct(){
        List<ProductResponseDTO> responseDTOS = productService.getAllProduct();
        return ResponseEntity.ok(
                responseDTOS
        );
    }
}
