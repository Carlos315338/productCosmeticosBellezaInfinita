package com.sena.productCosmeticosBellezaInfinita.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaginacionFiltroDTO {

    @NotNull
    private Integer page;

    @NotNull
    private Integer size;

    @NotBlank
    private String sortField;

    @NotBlank
    private String sortOrder;

    @NotNull
    private String nombre;

}
