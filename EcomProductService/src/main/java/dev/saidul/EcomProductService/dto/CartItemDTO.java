package dev.saidul.EcomProductService.dto;

import dev.saidul.EcomProductService.entity.CartItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemDTO {
    private String title;
    private int quantity;
    public static CartItemDTO from(CartItem cartItem){
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setTitle(cartItem.getTitle());
        cartItemDTO.setQuantity(cartItemDTO.getQuantity());
        return cartItemDTO;
    }
}
