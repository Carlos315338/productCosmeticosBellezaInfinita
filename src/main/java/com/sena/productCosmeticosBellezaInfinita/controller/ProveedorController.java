package com.sena.productCosmeticosBellezaInfinita.controller;

import com.sena.productCosmeticosBellezaInfinita.dto.ApiResponse;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/proveedorSelect")
    public ResponseEntity<ApiResponse<List<ProveedorSelectDTO>>> listarProveedoresSelect() {
        List<ProveedorSelectDTO> proveedoresSelect = proveedorService.obtenerProveedoresParaSelect();
        return ResponseEntity.ok(ApiResponse.ok("Operacion Exitosa", proveedoresSelect));
    }

    @GetMapping("/proveedores")
    public ResponseEntity<ApiResponse<Page<ProveedorDTO>>> listarProveedores(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<ProveedorDTO> proveedores = proveedorService.obtenerProveedores(page, size);
        return ResponseEntity.ok(ApiResponse.ok("Operacion Exitosa", proveedores));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> listarProveedores(@PathVariable String id) {
        String message = proveedorService.eliminarProveedor(id);
        return ResponseEntity.ok(ApiResponse.ok(message));
    }
}
