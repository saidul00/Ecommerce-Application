package dev.saidul.EcomProductService.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class CartItem extends BaseModel{
    private UUID productId;
    private int quantity;
}
