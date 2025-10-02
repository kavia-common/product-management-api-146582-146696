package com.example.productsbackendapi.service;

import com.example.productsbackendapi.dto.ProductRequest;
import com.example.productsbackendapi.dto.ProductResponse;
import com.example.productsbackendapi.exception.ProductNotFoundException;
import com.example.productsbackendapi.mapper.ProductMapper;
import com.example.productsbackendapi.model.Product;
import com.example.productsbackendapi.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Product service with transactional boundaries and clean methods.
 */
@Service
@Transactional
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // PUBLIC_INTERFACE
    public List<ProductResponse> listAll() {
        return repository.findAll().stream().map(ProductMapper::toResponse).toList();
    }

    // PUBLIC_INTERFACE
    public ProductResponse getById(Long id) {
        Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        return ProductMapper.toResponse(product);
    }

    // PUBLIC_INTERFACE
    public ProductResponse create(ProductRequest request) {
        Product saved = repository.save(ProductMapper.toEntity(request));
        return ProductMapper.toResponse(saved);
    }

    // PUBLIC_INTERFACE
    public ProductResponse update(Long id, ProductRequest request) {
        Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        ProductMapper.updateEntity(product, request);
        Product saved = repository.save(product);
        return ProductMapper.toResponse(saved);
    }

    // PUBLIC_INTERFACE
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
