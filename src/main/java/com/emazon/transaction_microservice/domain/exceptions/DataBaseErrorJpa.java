package com.emazon.transaction_microservice.domain.exceptions;

public class DataBaseErrorJpa extends RuntimeException {
    public DataBaseErrorJpa(String message) {
        super(message);
    }
}
