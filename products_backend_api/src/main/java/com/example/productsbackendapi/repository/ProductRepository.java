package com.example.productsbackendapi.repository;

import com.example.productsbackendapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Product persistence operations.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
