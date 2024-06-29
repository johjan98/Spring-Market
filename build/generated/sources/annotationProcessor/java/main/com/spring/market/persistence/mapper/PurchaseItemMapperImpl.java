package com.spring.market.persistence.mapper;

import com.spring.market.domain.PurchaseItem;
import com.spring.market.persistence.entity.ComprasProducto;
import com.spring.market.persistence.entity.ComprasProductoPK;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-26T14:51:37-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class PurchaseItemMapperImpl implements PurchaseItemMapper {

    @Override
    public PurchaseItem toPurchaseItem(ComprasProducto comprasProducto) {
        if ( comprasProducto == null ) {
            return null;
        }

        PurchaseItem purchaseItem = new PurchaseItem();

        Integer idProducto = comprasProductoIdIdProducto( comprasProducto );
        if ( idProducto != null ) {
            purchaseItem.setProductId( idProducto );
        }
        if ( comprasProducto.getCantidad() != null ) {
            purchaseItem.setQuantity( comprasProducto.getCantidad() );
        }
        if ( comprasProducto.getEstado() != null ) {
            purchaseItem.setActive( comprasProducto.getEstado() );
        }
        if ( comprasProducto.getTotal() != null ) {
            purchaseItem.setTotal( comprasProducto.getTotal() );
        }

        return purchaseItem;
    }

    @Override
    public ComprasProducto toComprasProducto(PurchaseItem purchaseItem) {
        if ( purchaseItem == null ) {
            return null;
        }

        ComprasProducto comprasProducto = new ComprasProducto();

        comprasProducto.setId( purchaseItemToComprasProductoPK( purchaseItem ) );
        comprasProducto.setCantidad( purchaseItem.getQuantity() );
        comprasProducto.setEstado( purchaseItem.isActive() );
        comprasProducto.setTotal( purchaseItem.getTotal() );

        return comprasProducto;
    }

    private Integer comprasProductoIdIdProducto(ComprasProducto comprasProducto) {
        if ( comprasProducto == null ) {
            return null;
        }
        ComprasProductoPK id = comprasProducto.getId();
        if ( id == null ) {
            return null;
        }
        Integer idProducto = id.getIdProducto();
        if ( idProducto == null ) {
            return null;
        }
        return idProducto;
    }

    protected ComprasProductoPK purchaseItemToComprasProductoPK(PurchaseItem purchaseItem) {
        if ( purchaseItem == null ) {
            return null;
        }

        ComprasProductoPK comprasProductoPK = new ComprasProductoPK();

        comprasProductoPK.setIdProducto( purchaseItem.getProductId() );

        return comprasProductoPK;
    }
}
