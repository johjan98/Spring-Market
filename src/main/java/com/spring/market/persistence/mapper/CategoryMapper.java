package com.spring.market.persistence.mapper;

import com.spring.market.domain.Category;
import com.spring.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * This class has the task of translating the Categoria class to Category class.
 * Here we need to use MapStruct dependency
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "idCategoria", target = "categoryId")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "estado", target = "active")
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
