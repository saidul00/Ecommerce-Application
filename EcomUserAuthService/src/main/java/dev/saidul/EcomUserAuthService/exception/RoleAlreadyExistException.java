package dev.saidul.EcomUserAuthService.exception;

public class RoleAlreadyExistException extends Exception{
    public RoleAlreadyExistException(String message){
        super(message);
    }
}
