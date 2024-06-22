package dev.saidul.EcomProductService.exception;

public class InsufficientInventoryException extends RuntimeException{
    public InsufficientInventoryException(String message) {
        super(message);
    }

    public InsufficientInventoryException() {
    }
}
