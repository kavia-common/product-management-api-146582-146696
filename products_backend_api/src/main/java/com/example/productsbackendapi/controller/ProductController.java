package com.example.productsbackendapi.controller;

import com.example.productsbackendapi.dto.ProductRequest;
import com.example.productsbackendapi.dto.ProductResponse;
import com.example.productsbackendapi.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Products REST controller.
 * Endpoints designed with clarity and minimalism, aligned to Ocean Professional aesthetics.
 */
@RestController
@RequestMapping("/products")
@Tag(name = "Products", description = "CRUD operations for Products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    /**
     * PUBLIC_INTERFACE
     * GET /products - List all products.
     * @return List<ProductResponse> all products.
     */
    @GetMapping
    @Operation(
            summary = "List products",
            description = "Retrieve all products in inventory.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of products returned",
                            content = @Content(schema = @Schema(implementation = ProductResponse.class)))
            }
    )
    public List<ProductResponse> getAll() {
        return service.listAll();
    }

    /**
     * PUBLIC_INTERFACE
     * GET /products/{id} - Get a product by id.
     * @param id product id
     * @return ProductResponse product data
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Get product by id",
            description = "Retrieve a single product by its identifier.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Product found",
                            content = @Content(schema = @Schema(implementation = ProductResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Product not found")
            }
    )
    public ProductResponse getById(
            @Parameter(description = "Product ID", required = true) @PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * PUBLIC_INTERFACE
     * POST /products - Create a new product.
     * @param request product payload
     * @return ProductResponse created product
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Create product",
            description = "Create a new product with name, price, and quantity.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Product created",
                            content = @Content(schema = @Schema(implementation = ProductResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error")
            }
    )
    public ProductResponse create(@Valid @RequestBody ProductRequest request) {
        return service.create(request);
    }

    /**
     * PUBLIC_INTERFACE
     * PUT /products/{id} - Update an existing product.
     * @param id product id
     * @param request product payload
     * @return ProductResponse updated product
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Update product",
            description = "Update an existing product by id.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Product updated",
                            content = @Content(schema = @Schema(implementation = ProductResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error"),
                    @ApiResponse(responseCode = "404", description = "Product not found")
            }
    )
    public ProductResponse update(
            @Parameter(description = "Product ID", required = true) @PathVariable Long id,
            @Valid @RequestBody ProductRequest request) {
        return service.update(id, request);
    }

    /**
     * PUBLIC_INTERFACE
     * DELETE /products/{id} - Delete a product by id.
     * @param id product id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete product",
            description = "Delete a product by id. Returns 204 on success.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Product deleted"),
                    @ApiResponse(responseCode = "404", description = "Product not found")
            }
    )
    public void delete(
            @Parameter(description = "Product ID", required = true) @PathVariable Long id) {
        service.delete(id);
    }
}
