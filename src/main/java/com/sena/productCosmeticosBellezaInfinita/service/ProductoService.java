package com.sena.productCosmeticosBellezaInfinita.service;

import com.sena.productCosmeticosBellezaInfinita.dto.ProductoDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProductoFiltroDTO;

import org.springframework.data.domain.Page;

public interface ProductoService {

    public Page<ProductoDTO> listarProductos(ProductoFiltroDTO filtro);
    public String eliminarProduto(String id);
    public Long obtenerCantidadProductos();
}
