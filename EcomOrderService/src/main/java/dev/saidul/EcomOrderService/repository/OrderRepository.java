package dev.saidul.EcomOrderService.repository;

import dev.saidul.EcomOrderService.enitty.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
}
