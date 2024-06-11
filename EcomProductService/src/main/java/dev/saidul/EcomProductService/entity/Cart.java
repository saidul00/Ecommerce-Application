package dev.saidul.EcomProductService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Cart extends BaseModel{
    private UUID userid;
    @OneToMany
    private List<CartItem> cartItem;
}
