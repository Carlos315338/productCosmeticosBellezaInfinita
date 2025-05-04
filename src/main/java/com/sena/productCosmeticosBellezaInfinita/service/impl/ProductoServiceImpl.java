package com.sena.productCosmeticosBellezaInfinita.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sena.productCosmeticosBellezaInfinita.dto.PaginacionFiltroDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProductoDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProductoUpdateDTO;
import com.sena.productCosmeticosBellezaInfinita.entity.Categoria;
import com.sena.productCosmeticosBellezaInfinita.entity.Producto;
import com.sena.productCosmeticosBellezaInfinita.entity.Proveedor;
import com.sena.productCosmeticosBellezaInfinita.mapper.ProductoMapper;
import com.sena.productCosmeticosBellezaInfinita.repository.CategoriaRepository;
import com.sena.productCosmeticosBellezaInfinita.repository.ProductoRepository;
import com.sena.productCosmeticosBellezaInfinita.repository.ProveedorRepository;
import com.sena.productCosmeticosBellezaInfinita.service.ProductoService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public Page<ProductoDTO> listarProductos(PaginacionFiltroDTO filtro) {

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

    @Override
    public ProductoDTO actualizacionProducto(String id, ProductoUpdateDTO productoDTO) {
        Producto existente = productoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con ID: " + id));

        existente.setCodigoDeBarras(productoDTO.getCodigoDeBarras());
        existente.setNombre(productoDTO.getNombre());
        existente.setDescripcion(productoDTO.getDescripcion());
        existente.setPrecio(productoDTO.getPrecio());
        existente.setStock(productoDTO.getStock());

        if (productoDTO.getCategoriaId() != null && productoDTO.getCategoriaId() != null) {
            Categoria categoria = categoriaRepository.findById(productoDTO.getCategoriaId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Categoría no encontrada con ID: " + productoDTO.getCategoriaId()));
            existente.setCategoria(categoria);
        }

        if (productoDTO.getProveedorId() != null && productoDTO.getProveedorId() != null) {
            Proveedor proveedor = proveedorRepository.findById(productoDTO.getProveedorId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Proveedor no encontrado con ID: " + productoDTO.getProveedorId()));
            existente.setProveedor(proveedor);
        }

        Producto actualizado = productoRepository.save(existente);
        return productoMapper.productoToProductoDTO(actualizado);
    }

}
