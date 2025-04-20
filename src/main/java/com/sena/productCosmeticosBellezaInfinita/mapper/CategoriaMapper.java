package com.sena.productCosmeticosBellezaInfinita.mapper;

import com.sena.productCosmeticosBellezaInfinita.dto.CategoriaDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProductoDTO;
import com.sena.productCosmeticosBellezaInfinita.entity.Categoria;
import com.sena.productCosmeticosBellezaInfinita.entity.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaMapper {

    CategoriaDTO categoriaToCategoriaDTO(Categoria categoria);
}
