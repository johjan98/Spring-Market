package com.spring.market.persistance;

import com.spring.market.persistance.crud.ProductoCrudRepository;
import com.spring.market.persistance.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //le indicamos a la clase que es la encargada de interactuar con la base de datos.
public class ProductoRepository {
  private ProductoCrudRepository productoCrudRepository;

  public List<Producto> getAll(){
    return (List<Producto>) productoCrudRepository.findAll();
  }

  public List<Producto> getByCategoria(int idCategoria){
    return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
  }

  public Optional<List<Producto>> getEscasos(int cantidad){
    return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
  }

  public Optional<Producto> getProducto(int idProducto){
    return productoCrudRepository.findById(idProducto);
  }

  public Producto save(Producto producto){
    return productoCrudRepository.save(producto);
  }

  public void delete(int idProducto){
    productoCrudRepository.deleteById(idProducto);
  }
}
