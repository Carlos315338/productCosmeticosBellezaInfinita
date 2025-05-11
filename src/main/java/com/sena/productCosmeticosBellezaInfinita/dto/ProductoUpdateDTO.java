package com.sena.productCosmeticosBellezaInfinita.dto;

import java.math.BigDecimal;

import lombok.*;

import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductoUpdateDTO {

    private String idProducto;

    @NotBlank(message = "El código de barras es obligatorio.")
    private String codigoDeBarras;

    @NotBlank(message = "El nombre es obligatorio.")
    private String nombre;

    @NotBlank(message = "La descripción es obligatoria.")
    private String descripcion;

    @NotNull(message = "El precio es obligatorio.")
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio debe ser mayor o igual a 0.")
    private BigDecimal precio;

    @NotNull(message = "El stock es obligatorio.")
    @Min(value = 0, message = "El stock no puede ser negativo.")
    private Integer stock;

    @NotBlank(message = "La categoría es obligatoria.")
    private String categoriaId;

    @NotBlank(message = "El proveedor es obligatorio.")
    private String proveedorId;
}

