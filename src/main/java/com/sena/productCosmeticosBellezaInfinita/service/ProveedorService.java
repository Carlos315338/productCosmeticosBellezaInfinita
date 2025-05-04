package com.sena.productCosmeticosBellezaInfinita.service;

import com.sena.productCosmeticosBellezaInfinita.dto.PaginacionFiltroDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProveedorDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProveedorSelectDTO;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ProveedorService {

    public List<ProveedorSelectDTO> obtenerProveedoresParaSelect();

    public Page<ProveedorDTO> obtenerProveedores(PaginacionFiltroDTO filtro);

    public String eliminarProveedor(String id);

    public Long obtenerCantidadProveedores();

    public ProveedorDTO actualizacionProveedor(String id, ProveedorDTO proveedor);
}
