package com.spring.market.domain.service;

import com.spring.market.domain.Product;
import com.spring.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Las clases con la anotacion @Service tienen la funcion de servir como
 * intermediario entre los controller y la capa del repositorio*/
@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public List<Product> getAll(){
    return productRepository.getAll();
  }

  public Optional<Product> getProduct(int productId){
    return productRepository.getProduct(productId);
  }

  public Optional<List<Product>> getByCategory(int categpryId){
    return productRepository.getByCategory(categpryId);
  }

  public Product save(Product product){
    return productRepository.save(product);
  }

  public boolean delete(int productId){
    return getProduct(productId).map(product -> {
      productRepository.delete(productId);
      return true;
    }).orElse(false);
  }
}
