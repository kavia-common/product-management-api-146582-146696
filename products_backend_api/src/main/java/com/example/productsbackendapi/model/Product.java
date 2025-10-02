package com.example.productsbackendapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Product entity representing a product record.
 * Clean, minimal structure following the Ocean Professional theme.
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Product name (required, concise)
    @Column(nullable = false)
    private String name;

    // Price with scale for currency-safe operations
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal price;

    // Available stock quantity
    @Column(nullable = false)
    private Integer quantity;

    public Product() {}

    public Product(Long id, String name, BigDecimal price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters/Setters (kept explicit for clarity and readability)
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
