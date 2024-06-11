package dev.saidul.EcomProductService.repository;

import dev.saidul.EcomProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
