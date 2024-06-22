package dev.saidul.EcomProductService.service;

import dev.saidul.EcomProductService.dto.CartCreationDTO;
import dev.saidul.EcomProductService.dto.CartResponseDTO;
import dev.saidul.EcomProductService.dto.CartModificationRequestDTO;
import dev.saidul.EcomProductService.entity.Cart;
import dev.saidul.EcomProductService.entity.CartItem;
import dev.saidul.EcomProductService.entity.Product;
import dev.saidul.EcomProductService.exception.CartNotFoundException;
import dev.saidul.EcomProductService.exception.InsufficientInventoryException;
import dev.saidul.EcomProductService.exception.InvalidActionException;
import dev.saidul.EcomProductService.exception.ProductNotFoundException;
import dev.saidul.EcomProductService.repository.CartRepository;
import dev.saidul.EcomProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository){
        this.cartRepository=cartRepository;
        this.productRepository=productRepository;
    }

    @Override
    public CartResponseDTO addToCart(CartCreationDTO cartCreationDTO) {
        Optional<Cart> savedCartOptional = cartRepository.findByUserId(cartCreationDTO.getUserId());
        if(savedCartOptional.isEmpty()){
            Cart cart = new Cart();
            cart.setUserId(cartCreationDTO.getUserId());
            List<CartItem> items = new ArrayList<>();
            items.add(addFromInventory(cartCreationDTO.getProductId(), cartCreationDTO.getQuantity()));
            cart.setCartItem(items);
            Cart saveCart = cartRepository.save(cart);
            return CartResponseDTO.from(saveCart);
        } else {
            Cart savedCart = savedCartOptional.get();
            List<CartItem> existingCartItems = savedCart.getCartItem();
            existingCartItems.add(addFromInventory(cartCreationDTO.getProductId(), cartCreationDTO.getQuantity()));
            savedCart.setCartItem(existingCartItems);
            Cart updatedCart = cartRepository.save(savedCart);
            return CartResponseDTO.from(updatedCart);
        }
    }

    @Override
    public CartResponseDTO getCartByUserId(UUID userId) {
        Cart savedCart = cartRepository.findByUserId(userId).orElseThrow(
                ()-> new CartNotFoundException("Cart not found for given user!")
        );
        return CartResponseDTO.from(savedCart);
    }

    @Override
    public CartResponseDTO updateCart(CartModificationRequestDTO cartModificationRequestDTO) {
        Cart savedCart = cartRepository.findById(cartModificationRequestDTO.getCartId()).orElseThrow(
                ()-> new CartNotFoundException("Cart not found!")
        );
        UUID productId = cartModificationRequestDTO.getProductId();
        String action = cartModificationRequestDTO.getAction();
        int quantity = cartModificationRequestDTO.getQuantity();

        CartItem cartItem = savedCart.getCartItem().stream()
                .filter(item -> item.getProductId().equals(productId))
                .findFirst()
                .orElseThrow(()-> new ProductNotFoundException("Product not found in cart!"));
        switch (action){
            case "update":
                if(quantity > 0){
                    updateQuantity(cartItem,quantity);
                }else {
                    throw new InvalidActionException("Invalid quantity!");
                }
                break;
            case "remove":
                updateQuantity(cartItem,0);
                savedCart.getCartItem().remove(cartItem);
                break;
            default:
                throw new InvalidActionException("Invalid action specified");
        }
        Cart updatedCart = cartRepository.save(savedCart);
        return CartResponseDTO.from(updatedCart);
    }

    private CartItem addFromInventory(UUID productId, int quantity){
        Product savedProduct = productRepository.findById(productId).orElseThrow(
                ()-> new ProductNotFoundException("Product does not exist!")
        );
        if(savedProduct.getInventoryCount()<quantity){
            throw new InsufficientInventoryException("Not enough inventory for the requested quantity!");
        }
        CartItem item = new CartItem();
        item.setProductId(savedProduct.getId());
        item.setTitle(savedProduct.getTitle());
        item.setQuantity(quantity);
        savedProduct.setInventoryCount(savedProduct.getInventoryCount()-quantity);
        productRepository.save(savedProduct);
        return item;
    }

    private void updateQuantity(CartItem cartItem, int newQuantity){
        Product savedProduct = productRepository.findById(cartItem.getProductId()).orElseThrow(
                ()-> new ProductNotFoundException("Invalid product!")
        );

        int quantityDifference = newQuantity-cartItem.getQuantity();
        if(quantityDifference > 0 && savedProduct.getInventoryCount() < quantityDifference){
            throw new InsufficientInventoryException("Not enough inventory for the requested quantity!");
        }
        savedProduct.setInventoryCount(savedProduct.getInventoryCount()-quantityDifference);
        productRepository.save(savedProduct);
        cartItem.setQuantity(newQuantity);
    }
}
