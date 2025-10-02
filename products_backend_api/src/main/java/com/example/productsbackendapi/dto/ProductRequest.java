package com.example.productsbackendapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * Request payload for creating/updating a product.
 */
public class ProductRequest {

    @Schema(description = "Product name", example = "Ocean Breeze Mug")
    @NotBlank
    private String name;

    @Schema(description = "Product price", example = "19.99")
    @NotNull
    @Min(0)
    private BigDecimal price;

    @Schema(description = "Available quantity", example = "100")
    @NotNull
    @Min(0)
    private Integer quantity;

    public ProductRequest() {}

    public ProductRequest(String name, BigDecimal price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
