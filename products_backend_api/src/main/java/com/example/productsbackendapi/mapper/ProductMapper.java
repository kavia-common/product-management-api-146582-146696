package com.example.productsbackendapi.mapper;

import com.example.productsbackendapi.dto.ProductRequest;
import com.example.productsbackendapi.dto.ProductResponse;
import com.example.productsbackendapi.model.Product;

/**
 * Minimal mapper to keep controller/service lean and focused.
 */
public final class ProductMapper {

    private ProductMapper() {}

    public static Product toEntity(ProductRequest request) {
        Product p = new Product();
        p.setName(request.getName());
        p.setPrice(request.getPrice());
        p.setQuantity(request.getQuantity());
        return p;
    }

    public static void updateEntity(Product entity, ProductRequest request) {
        entity.setName(request.getName());
        entity.setPrice(request.getPrice());
        entity.setQuantity(request.getQuantity());
    }

    public static ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity()
        );
    }
}
