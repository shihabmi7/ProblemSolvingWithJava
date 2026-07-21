package com.shihab.springboot.exception;

/**
 * Unchecked, custom exception for "not found" cases. Kept simple and free of
 * any Spring imports - it's plain Java, translated into an HTTP 404 by
 * GlobalExceptionHandler. This separation (domain exception vs. HTTP status)
 * is itself a common interview talking point.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
