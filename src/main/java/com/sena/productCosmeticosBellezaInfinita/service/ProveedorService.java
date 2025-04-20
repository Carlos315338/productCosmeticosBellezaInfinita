package com.sena.productCosmeticosBellezaInfinita.service;

import com.sena.productCosmeticosBellezaInfinita.dto.ProveedorSelectDTO;

import java.util.List;

public interface ProveedorService {

    public List<ProveedorSelectDTO> obtenerProveedoresParaSelect();
}
