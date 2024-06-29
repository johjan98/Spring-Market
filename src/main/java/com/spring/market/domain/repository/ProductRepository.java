package com.spring.market.domain.repository;

import com.spring.market.domain.Product;

import java.util.List;
import java.util.Optional;

/**
 * In this repository there are the methods of ProductoRespository
 * that we want to use in the application's domain
 */
public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
