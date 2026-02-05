package com.lld.eventbus.exception;

public class RetryAbleException extends RuntimeException {
    public RetryAbleException(String message) {
        super(message);
    }
}
