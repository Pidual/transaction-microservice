package com.emazon.transaction_microservice.infrastructure.security;

public class CustomJwtException extends RuntimeException {
    public CustomJwtException(String message) {
        super(message);
    }
}
