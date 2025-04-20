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
@Table(name = "categoria")
public class Categoria {

    @Id
    @Column(name = "id_categoria")
    private String idCategoria = UUID.randomUUID().toString();

    @Column(name = "nombre_categoria", length = 100, nullable = false, unique = true)
    private String nombreCategoria;
}
