package com.sena.productCosmeticosBellezaInfinita.mapper;

import com.sena.productCosmeticosBellezaInfinita.dto.ProductoDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProveedorDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProveedorSelectDTO;
import com.sena.productCosmeticosBellezaInfinita.entity.Producto;
import com.sena.productCosmeticosBellezaInfinita.entity.Proveedor;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProveedorMapper {

    ProveedorDTO proveedorToProveedorDTO(Proveedor proveedor);
    Proveedor proveedorDTOToProveedor(ProveedorDTO proveedor);

    @Mapping(source = "idProveedor", target = "idProveedor")
    @Mapping(source = "nombreProveedor", target = "nombreProveedor")
    @BeanMapping(ignoreByDefault = true)
    ProveedorSelectDTO proveedorToProveedorSelectDTO(Proveedor proveedor);

    List<ProveedorSelectDTO> listProveedorToProveedorSelectDTO(List<Proveedor> proveedores);


}
