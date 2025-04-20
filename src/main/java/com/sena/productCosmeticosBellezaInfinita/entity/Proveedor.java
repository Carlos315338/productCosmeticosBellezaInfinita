package com.sena.productCosmeticosBellezaInfinita.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @Column(name = "id_proveedor")
    private String idProveedor = UUID.randomUUID().toString();;

    @Column(name = "nit_proveedor", nullable = false, unique = true)
    private String nitProveedor;

    @Column(name = "nombre_proveedor", length = 100, nullable = false)
    private String nombreProveedor;

    @Column(name = "correo_electronico", length = 100, nullable = false, unique = true)
    private String correoElectronico;

    @Column(name = "telefono", length = 15)
    private String telefono;
}