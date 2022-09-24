package com.spring.market.persistance;

import com.spring.market.persistance.crud.ProductoCrudRepository;
import com.spring.market.persistance.entity.Producto;

import java.util.List;
import java.util.Optional;

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
}
