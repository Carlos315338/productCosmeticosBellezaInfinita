package com.sena.productCosmeticosBellezaInfinita.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sena.productCosmeticosBellezaInfinita.dto.ProductoDTO;
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
    public Page<ProductoDTO> listarProductos(int page, int size, String orden) {

        Page<Producto> productosPage = productoRepository
                .findAll(PageRequest.of(page, size, Sort.by(orden).ascending()));
        List<Producto> content = productosPage.getContent();
        List<ProductoDTO> productoDTOS = productoMapper.listProductoToListProductoDTO(content);

        Page<ProductoDTO> dtoPage = new PageImpl<>(
                productoDTOS,
                PageRequest.of(page, size),
                productosPage.getTotalElements());

        return dtoPage;
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
