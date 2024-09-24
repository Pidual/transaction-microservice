package com.emazon.transaction_microservice.application.handler;

public class FeignClientException extends RuntimeException {
    public FeignClientException(String message) {
        super(message);
    }
}
