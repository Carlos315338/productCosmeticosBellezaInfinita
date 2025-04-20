package com.sena.productCosmeticosBellezaInfinita.service.impl;

import com.sena.productCosmeticosBellezaInfinita.dto.ProductoDTO;
import com.sena.productCosmeticosBellezaInfinita.entity.Producto;
import com.sena.productCosmeticosBellezaInfinita.mapper.ProductoMapper;
import com.sena.productCosmeticosBellezaInfinita.repository.ProductoRepository;
import com.sena.productCosmeticosBellezaInfinita.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    public Page<ProductoDTO> listarProductos(int page,  int size, String orden){

        Page<Producto> productosPage = productoRepository.findAll(PageRequest.of(page, size, Sort.by(orden).ascending()));
        List<Producto> content = productosPage.getContent();
        List<ProductoDTO> productoDTOS = productoMapper.listProductoToListProductoDTO(content);

        Page<ProductoDTO> dtoPage = new PageImpl<>(
                productoDTOS,
                PageRequest.of(page, size),
                productosPage.getTotalElements()
        );

        return dtoPage;
    }

}
