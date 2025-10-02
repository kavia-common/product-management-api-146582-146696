package com.example.productsbackendapi.exception;

/**
 * Exception for missing products by id.
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Product not found with id: " + id);
    }
}
