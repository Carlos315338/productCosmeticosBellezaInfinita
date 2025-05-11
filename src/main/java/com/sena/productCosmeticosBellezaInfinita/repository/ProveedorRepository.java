package com.sena.productCosmeticosBellezaInfinita.repository;

import com.sena.productCosmeticosBellezaInfinita.entity.Proveedor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, String> {

    Page<Proveedor> findByNombreProveedorContainingIgnoreCase(String nombre, Pageable pageable);

    boolean existsByNitProveedor(String nitProveedor);

}
