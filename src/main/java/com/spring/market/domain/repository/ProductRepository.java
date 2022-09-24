package com.spring.market.domain.repository;

import com.spring.market.domain.Product;

import java.util.List;
import java.util.Optional;

/**
 * Interface para indicar el nombre de los metodos que se quieren implementar
 * desde cualquier repositorio que necesite trabajar con productos.
 * En este caso los metodos utilizados son de la clase ProductoRepository*/
public interface ProductRepository {
  List<Product> getAll();
  Optional<List<Product>> getByCategory(int categpryId);
  Optional<List<Product>> getScarseProducts(int quantity);
  Optional<Product> getProduct(int productId);
  Product save(Product product);
  void delete(int productId);
}
