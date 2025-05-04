package com.sena.productCosmeticosBellezaInfinita.mapper;

import com.sena.productCosmeticosBellezaInfinita.dto.CategoriaDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.CategoriaSelectDTO;
import com.sena.productCosmeticosBellezaInfinita.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaMapper {

    CategoriaDTO categoriaToCategoriaDTO(Categoria categoria);
    Categoria categoriaDTOToCategoria(CategoriaDTO categoria);

    @Mapping(source = "idCategoria", target = "idCategoria")
    @Mapping(source = "nombreCategoria", target = "nombreCategoria")
    CategoriaSelectDTO categoriaToCategoriaSelectDTO(Categoria categoria);
    List<CategoriaSelectDTO> listCategoriaToCategoriaSelectDTO(List<Categoria> categorias);

}
