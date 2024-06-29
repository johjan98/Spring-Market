package com.spring.market.persistence.mapper;

import com.spring.market.domain.PurchaseItem;
import com.spring.market.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Here we use ProductMapper to translate Product to Product in toComprasProducto method.
 * It doesn't matter if it's to ignore it.
 */
@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mapping(source = "id.idProducto", target = "productId")
    @Mapping(source = "cantidad", target = "quantity")
    @Mapping(source = "estado", target = "active")
    PurchaseItem toPurchaseItem(ComprasProducto comprasProducto);

    @InheritInverseConfiguration
    @Mapping(target = "compra", ignore = true)
    @Mapping(target = "producto", ignore = true)
    @Mapping(target = "id.idCompra", ignore = true)
    ComprasProducto toComprasProducto(PurchaseItem purchaseItem);
}
