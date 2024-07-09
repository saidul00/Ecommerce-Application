package dev.saidul.EcomProductService.service;

import dev.saidul.EcomProductService.dto.ProductCreationDTO;
import dev.saidul.EcomProductService.dto.ProductResponseDTO;
import dev.saidul.EcomProductService.entity.Product;
import dev.saidul.EcomProductService.exception.CategoryNotFoundException;
import dev.saidul.EcomProductService.exception.ProductNotFoundException;
import dev.saidul.EcomProductService.repository.CategoryRepository;
import dev.saidul.EcomProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }


    @Override
    public ProductResponseDTO createProduct(ProductCreationDTO productCreationDTO) {
        Product product = new Product();
        product.setTitle(productCreationDTO.getTitle());
        product.setPrice(productCreationDTO.getPrice());
        product.setDescription(productCreationDTO.getDescription());
        product.setCategory(categoryRepository.findById(productCreationDTO.getCategoryId()).orElseThrow(
                ()-> new CategoryNotFoundException("Category not  found")
        ));
        product.setImageURL(productCreationDTO.getImageURL());
        return ProductResponseDTO.from(productRepository.save(product));
    }

    @Override
    public ProductResponseDTO getProductById(UUID id) {
        Product savedProduct = productRepository.findById(id).orElseThrow(
                ()-> new ProductNotFoundException("Product not found")
        );
        return ProductResponseDTO.from(savedProduct);
    }

    @Override
    public List<ProductResponseDTO> getAllProduct(){
        List<Product> allProduct = productRepository.findAll();

        return allProduct.stream().map(ProductResponseDTO::from).toList();
    }
}
