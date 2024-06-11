package dev.saidul.EcomProductService.controller;

import dev.saidul.EcomProductService.dto.ProductCreationDTO;
import dev.saidul.EcomProductService.dto.ProductResponseDTO;
import dev.saidul.EcomProductService.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
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
}
