package com.sena.productCosmeticosBellezaInfinita.controller;

import com.sena.productCosmeticosBellezaInfinita.dto.ApiResponse;
import com.sena.productCosmeticosBellezaInfinita.dto.PaginacionFiltroDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProductoDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProductoUpdateDTO;
import com.sena.productCosmeticosBellezaInfinita.service.ProductoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/productos")
    public ResponseEntity<ApiResponse<Page<ProductoDTO>>> listarProductos(@Valid @RequestBody PaginacionFiltroDTO filtro) {

        Page<ProductoDTO> productos = productoService.listarProductos(filtro);
        return ResponseEntity.ok(ApiResponse.ok("Operacion Exitosa", productos));
    }

    @GetMapping("/cantidadProductos")
    public ResponseEntity<ApiResponse<Long>> obtenerCantidadProductos() {
        Long cantidadProductos = productoService.obtenerCantidadProductos();
        return ResponseEntity.ok(ApiResponse.ok("Operacion Exitosa", cantidadProductos));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<Void>> eliminarProducto(@PathVariable String id) {
        String eliminacion = productoService.eliminarProduto(id);
        return ResponseEntity.ok(ApiResponse.ok(eliminacion));
    }

    @PostMapping("updateProducto/{id}")
    public ResponseEntity<ApiResponse<ProductoDTO>> listarProveedores(@PathVariable String id, @RequestBody ProductoUpdateDTO producto) {
        ProductoDTO productoUpdate = productoService.actualizacionProducto(id, producto);
        return ResponseEntity.ok(ApiResponse.ok("Operacion Exitosa", productoUpdate));
    }

    @PostMapping("guardarProducto")
    public ResponseEntity<ApiResponse<Void>> guardarProducto(@Valid @RequestBody ProductoUpdateDTO producto) {
        productoService.guardarProducto(producto);
        return ResponseEntity.ok(ApiResponse.ok("Operacion Exitosa"));
    }

}
