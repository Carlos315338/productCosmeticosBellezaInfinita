package com.sena.productCosmeticosBellezaInfinita.dto;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProveedorDTO {

    private String idProveedor;
    private String nitProveedor;
    private String nombreProveedor;
    private String correoElectronico;
    private String telefono;
}