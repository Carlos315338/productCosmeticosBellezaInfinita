package com.sena.productCosmeticosBellezaInfinita.controller;

import com.sena.productCosmeticosBellezaInfinita.dto.ApiResponse;
import com.sena.productCosmeticosBellezaInfinita.dto.CategoriaSelectDTO;
import com.sena.productCosmeticosBellezaInfinita.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoriaSelect")
    public ResponseEntity<ApiResponse<List<CategoriaSelectDTO>>> listarProductosSelect() {
        List<CategoriaSelectDTO> categoriaSelect = categoriaService.obtenerProveedoresParaSelect();
        return ResponseEntity.ok(ApiResponse.ok("Operacion Exitosa", categoriaSelect));
    }

    @GetMapping("/cantidadCategoria")
    public ResponseEntity<ApiResponse<Long>> obtenerCantidadCategoria() {
        Long cantidadCategoria = categoriaService.obtenerCantidadCategoria();
        return ResponseEntity.ok(ApiResponse.ok("Operacion Exitosa", cantidadCategoria) );
    }
}
