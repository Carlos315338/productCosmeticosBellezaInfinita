package com.sena.productCosmeticosBellezaInfinita.mapper;

import com.sena.productCosmeticosBellezaInfinita.dto.ProductoDTO;
import com.sena.productCosmeticosBellezaInfinita.entity.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {CategoriaMapper.class, ProveedorMapper.class})
public interface ProductoMapper {
    ProductoDTO productoToProductoDTO(Producto producto);
    List<ProductoDTO> listProductoToListProductoDTO(List<Producto> productos);
}
