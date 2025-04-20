package com.sena.productCosmeticosBellezaInfinita.repository;

import com.sena.productCosmeticosBellezaInfinita.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, String> {
}
