package com.sena.productCosmeticosBellezaInfinita.controller;

import com.sena.productCosmeticosBellezaInfinita.dto.ApiResponse;
import com.sena.productCosmeticosBellezaInfinita.dto.PaginacionFiltroDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProveedorDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProveedorSelectDTO;
import com.sena.productCosmeticosBellezaInfinita.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/proveedorSelect")
    public ResponseEntity<ApiResponse<List<ProveedorSelectDTO>>> listarProveedoresSelect() {
        List<ProveedorSelectDTO> proveedoresSelect = proveedorService.obtenerProveedoresParaSelect();
        return ResponseEntity.ok(ApiResponse.ok("Operacion Exitosa", proveedoresSelect));
    }

    @PostMapping("/proveedores")
    public ResponseEntity<ApiResponse<Page<ProveedorDTO>>> listarProveedores(@RequestBody PaginacionFiltroDTO filtro) {

        Page<ProveedorDTO> proveedores = proveedorService.obtenerProveedores(filtro);
        return ResponseEntity.ok(ApiResponse.ok("Operacion Exitosa", proveedores));
    }

    @GetMapping("/cantidadProveedores")
    public ResponseEntity<ApiResponse<Long>> obtenerCantidadProveedores() {
        Long cantidadProveedores = proveedorService.obtenerCantidadProveedores();
        return ResponseEntity.ok(ApiResponse.ok("Operacion Exitosa", cantidadProveedores));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> listarProveedores(@PathVariable String id) {
        String message = proveedorService.eliminarProveedor(id);
        return ResponseEntity.ok(ApiResponse.ok(message));
    }

    @PostMapping("updateProveedor/{id}")
    public ResponseEntity<ApiResponse<ProveedorDTO>> listarProveedores(@PathVariable String id, @RequestBody ProveedorDTO proveedor) {
        ProveedorDTO proveedorUpdate = proveedorService.actualizacionProveedor(id, proveedor);
        return ResponseEntity.ok(ApiResponse.ok("Operacion Exitosa", proveedorUpdate));
    }

}
