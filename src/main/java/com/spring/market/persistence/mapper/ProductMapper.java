package com.spring.market.persistence.mapper;

import com.spring.market.domain.Product;
import com.spring.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * CategoryMapper.class is used to translating Categeria to Category in the mapping
 */
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mapping(source = "idProducto", target = "productId")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "idCategoria", target = "categoryId")
    @Mapping(source = "precioVenta", target = "price")
    @Mapping(source = "cantidadStock", target = "stock")
    @Mapping(source = "estado", target = "active")
    @Mapping(source = "categoria", target = "category")
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}
