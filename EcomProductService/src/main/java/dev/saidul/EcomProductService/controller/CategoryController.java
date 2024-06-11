package dev.saidul.EcomProductService.controller;

import dev.saidul.EcomProductService.dto.CategoryCreationDTO;
import dev.saidul.EcomProductService.dto.CategoryResponseDTO;
import dev.saidul.EcomProductService.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryCreationDTO categoryCreationDTO){
        return ResponseEntity.ok(
                categoryService.createCategory(categoryCreationDTO)
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable("id")UUID categoryId){
        return ResponseEntity.ok(
                categoryService.getCategoryById(categoryId)
        );
    }
}
