package com.sena.productCosmeticosBellezaInfinita.service;

import com.sena.productCosmeticosBellezaInfinita.dto.ProductoDTO;
import com.sena.productCosmeticosBellezaInfinita.entity.Producto;
import org.springframework.data.domain.Page;

public interface ProductoService {

    public Page<ProductoDTO> listarProductos(int page, int size, String orden);
}
