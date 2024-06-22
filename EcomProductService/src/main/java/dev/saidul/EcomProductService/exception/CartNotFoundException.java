package dev.saidul.EcomProductService.exception;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException() {
    }

    public CartNotFoundException(String message) {
        super(message);
    }
}
