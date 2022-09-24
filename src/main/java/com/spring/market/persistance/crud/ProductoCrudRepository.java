package com.spring.market.persistance.crud;

import com.spring.market.persistance.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> { //<Clase de la tabla, tipo de dato de la clave primaria>

  //Con @Query se puede ejecutar un query de forma nativa y nombrar el metodo de cualquier forma.
  //Pero en lo posible es mejor usar query methods para hacer consultas (Buena practica)
  //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
  List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

  //Metodo para hallar productos que se están agotando. Se ingresa una cantidad y si en stock hay menos
  // quiere decir que el producto está escaso.
  Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
