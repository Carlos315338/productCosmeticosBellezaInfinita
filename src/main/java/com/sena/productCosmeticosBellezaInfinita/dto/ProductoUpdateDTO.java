package com.sena.productCosmeticosBellezaInfinita.dto;

import java.math.BigDecimal;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductoUpdateDTO {

    private String idProducto;
    private String codigoDeBarras;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private String categoriaId;
    private String proveedorId;

}
