package dev.saidul.EcomOrderService.enitty;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class OrderItem extends BaseModel{
    private UUID  productId;
    private int quantity;
    private double price;
    private double totalPrice;
}
