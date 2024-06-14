package dev.saidul.EcomPaymentService.repository;

import dev.saidul.EcomPaymentService.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CurrencyRepository extends JpaRepository<Currency, UUID> {
}
