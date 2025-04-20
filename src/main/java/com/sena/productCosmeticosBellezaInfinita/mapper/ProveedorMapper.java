package com.sena.productCosmeticosBellezaInfinita.mapper;

import com.sena.productCosmeticosBellezaInfinita.dto.ProductoDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProveedorDTO;
import com.sena.productCosmeticosBellezaInfinita.entity.Producto;
import com.sena.productCosmeticosBellezaInfinita.entity.Proveedor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProveedorMapper {

    ProveedorDTO proveedorToProveedorDTO(Proveedor proveedor);
    Proveedor proveedorDTOToProveedor(ProveedorDTO proveedor);

}
