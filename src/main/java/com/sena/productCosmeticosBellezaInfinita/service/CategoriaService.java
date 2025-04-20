package com.sena.productCosmeticosBellezaInfinita.service;

import com.sena.productCosmeticosBellezaInfinita.dto.CategoriaSelectDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProveedorSelectDTO;

import java.util.List;

public interface CategoriaService {

    public List<CategoriaSelectDTO> obtenerProveedoresParaSelect();
}
