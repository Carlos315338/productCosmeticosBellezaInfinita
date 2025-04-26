package com.sena.productCosmeticosBellezaInfinita.service;

import com.sena.productCosmeticosBellezaInfinita.dto.CategoriaSelectDTO;

import java.util.List;

public interface CategoriaService {

    public List<CategoriaSelectDTO> obtenerProveedoresParaSelect();

    public Long obtenerCantidadCategoria();
}
