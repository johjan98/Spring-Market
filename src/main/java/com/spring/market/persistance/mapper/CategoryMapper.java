package com.spring.market.persistance.mapper;

import com.spring.market.domain.Category;
import com.spring.market.persistance.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Esta interface se encargará de mapear entre la entidad Categoria
 * y Category implementada en el dominio.*/
@Mapper(componentModel = "spring") //Indicar a mapstruct que es un componente de spring
public interface CategoryMapper {
  @Mappings({
          @Mapping(source = "idCategoria", target = "categoryId"), //source: fuente, target: destino
          @Mapping(source = "descripcion", target = "category"),
          @Mapping(source = "estado", target = "active")
  })
  Category toCategory(Categoria categoria);

  @InheritInverseConfiguration //Indica que esta conversión se configura de forma contraria que la anterior. En este casp es lo contrario de toCategory
  @Mapping(target = "productos", ignore = true) //Como category no contiene products, se ignora productos al mapear de Category a Categoria
  Categoria toCategoria(Category category);
}
