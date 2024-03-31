package org.example.onlinefoodstorage.exceptions.customExceptions;

public class BadCredentialException extends RuntimeException{
    public BadCredentialException(String message) {
        super(message);
    }
}
