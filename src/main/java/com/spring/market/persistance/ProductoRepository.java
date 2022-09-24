package com.spring.market.persistance;

import com.spring.market.domain.Product;
import com.spring.market.domain.repository.ProductRepository;
import com.spring.market.persistance.crud.ProductoCrudRepository;
import com.spring.market.persistance.entity.Producto;
import com.spring.market.persistance.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * En esta clase se utilizan los mappers creados con el fin de hacer una traduccion
 * entre atributos del dominio y la capa de persistencia
 * */
@Repository //le indicamos a la clase que es la encargada de interactuar con la base de datos.
public class ProductoRepository implements ProductRepository {
  private ProductoCrudRepository productoCrudRepository;
  private ProductMapper mapper;
  @Override
  public List<Product> getAll(){
    List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
    return mapper.toProducts(productos);
  }
  @Override
  public Optional<List<Product>> getByCategory(int categoryId){
    List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
    return Optional.of(mapper.toProducts(productos));
  }
  @Override
  public Optional<List<Product>> getScarseProducts(int quantity){
    Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
    return productos.map(prods -> mapper.toProducts(prods));
  }
  @Override
  public Optional<Product> getProduct(int productId){
    return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
  }
  @Override
  public Product save(Product product){
    Producto producto = mapper.toProducto(product);
    return mapper.toProduct(productoCrudRepository.save(producto));
  }
  @Override
  public void delete(int productId){
    productoCrudRepository.deleteById(productId);
  }
}
