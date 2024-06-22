package dev.saidul.EcomProductService.dto;

import dev.saidul.EcomProductService.entity.Cart;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CartResponseDTO {
    private UUID userId;
    private UUID cartId;
    private List<CartItemDTO> cartItems;
    public static CartResponseDTO from(Cart cart){
        CartResponseDTO cartResponseDTO = new CartResponseDTO();
        cartResponseDTO.setUserId(cart.getUserId());
        cartResponseDTO.setCartId(cart.getId());
        if(!cart.getCartItem().isEmpty()){
            List<CartItemDTO> cartItemDTOList = cart.getCartItem().stream().map(CartItemDTO::from).toList();
            cartResponseDTO.setCartItems(cartItemDTOList);
        }
        return cartResponseDTO;
    }
}
