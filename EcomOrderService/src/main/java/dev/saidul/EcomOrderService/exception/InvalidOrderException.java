package dev.saidul.EcomOrderService.exception;

public class InvalidOrderException extends RuntimeException{
    public InvalidOrderException(String message) {
        super(message);
    }
}
