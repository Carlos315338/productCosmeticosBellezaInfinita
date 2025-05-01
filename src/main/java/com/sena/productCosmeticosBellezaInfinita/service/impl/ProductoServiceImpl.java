package com.sena.productCosmeticosBellezaInfinita.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sena.productCosmeticosBellezaInfinita.dto.ProductoDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProductoFiltroDTO;
import com.sena.productCosmeticosBellezaInfinita.entity.Producto;
import com.sena.productCosmeticosBellezaInfinita.mapper.ProductoMapper;
import com.sena.productCosmeticosBellezaInfinita.repository.ProductoRepository;
import com.sena.productCosmeticosBellezaInfinita.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;
    
    @Override
    public Page<ProductoDTO> listarProductos(ProductoFiltroDTO filtro) {

        Sort sort = "desc".equalsIgnoreCase(filtro.getSortOrder())
                ? Sort.by(filtro.getSortField()).descending()
                : Sort.by(filtro.getSortField()).ascending();

        Pageable pageable = PageRequest.of(filtro.getPage(), filtro.getSize(), sort);

        Page<Producto> productosPage;

        if (filtro.getNombre() != null && !filtro.getNombre().trim().isEmpty()) {
            productosPage = productoRepository.findByNombreContainingIgnoreCase(filtro.getNombre(), pageable);
        } else {
            productosPage = productoRepository.findAll(pageable);
        }

        List<ProductoDTO> productoDTOS = productoMapper.listProductoToListProductoDTO(productosPage.getContent());

        return new PageImpl<>(productoDTOS, pageable, productosPage.getTotalElements());
    }

    @Override
    public Long obtenerCantidadProductos() {
        return productoRepository.count();
    }

    @Override
    public String eliminarProduto(String id) {
        try {

            productoRepository.deleteById(id);

            return "Operacion Exitosa";
        } catch (Exception e) {
            System.out.println("Error, " + e);
            return "Error Procesando la operacion";
        }
    }

}
