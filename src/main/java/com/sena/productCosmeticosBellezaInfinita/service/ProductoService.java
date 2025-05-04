package com.sena.productCosmeticosBellezaInfinita.service;

import com.sena.productCosmeticosBellezaInfinita.dto.PaginacionFiltroDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProductoDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProductoUpdateDTO;

import org.springframework.data.domain.Page;

public interface ProductoService {

    public Page<ProductoDTO> listarProductos(PaginacionFiltroDTO filtro);

    public String eliminarProduto(String id);

    public Long obtenerCantidadProductos();

    public ProductoDTO actualizacionProducto(String id, ProductoUpdateDTO productoDto);
}
