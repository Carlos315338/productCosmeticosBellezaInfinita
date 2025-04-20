package com.sena.productCosmeticosBellezaInfinita.dto;

import com.sena.productCosmeticosBellezaInfinita.entity.Categoria;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductoDTO {

    private String idProducto;
    private String codigoDeBarras;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private CategoriaDTO categoria;
    private ProveedorDTO proveedor;
}
