package dev.saidul.EcomProductService.service;

import dev.saidul.EcomProductService.dto.CategoryCreationDTO;
import dev.saidul.EcomProductService.dto.CategoryResponseDTO;
import dev.saidul.EcomProductService.entity.Category;
import dev.saidul.EcomProductService.exception.CategoryNotFoundException;
import dev.saidul.EcomProductService.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }
    @Override
    public CategoryResponseDTO createCategory(CategoryCreationDTO categoryCreationDTO) {
        Category category = new Category();
        category.setTitle(categoryCreationDTO.getTitle());
        Category savedCategory = categoryRepository.save(category);
        return CategoryResponseDTO.from(savedCategory);
    }

    @Override
    public CategoryResponseDTO getCategoryById(UUID categoryId) {
        Category savedCategory = categoryRepository.findById(categoryId).orElseThrow(
                ()-> new CategoryNotFoundException("Category not found")
        );

        return CategoryResponseDTO.from(savedCategory);
    }
}
