package com.sena.productCosmeticosBellezaInfinita.service.impl;

import com.sena.productCosmeticosBellezaInfinita.dto.ProveedorDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProveedorSelectDTO;
import com.sena.productCosmeticosBellezaInfinita.entity.Proveedor;
import com.sena.productCosmeticosBellezaInfinita.mapper.ProveedorMapper;
import com.sena.productCosmeticosBellezaInfinita.repository.ProveedorRepository;
import com.sena.productCosmeticosBellezaInfinita.service.ProveedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ProveedorMapper proveedorMapper;

    @Override
    public List<ProveedorSelectDTO> obtenerProveedoresParaSelect() {
        return proveedorMapper.listProveedorToProveedorSelectDTO(proveedorRepository.findAll());
    }

    public Page<ProveedorDTO> obtenerProveedores(int page, int size) {

        Page<Proveedor> proveedoresPage = proveedorRepository.findAll(PageRequest.of(page, size));

        List<ProveedorDTO> proveedorDTOs = proveedorMapper
                .listProveedorToListProveedorDTO(proveedoresPage.getContent());

        Page<ProveedorDTO> dtoPage = new PageImpl<>(
                proveedorDTOs,
                PageRequest.of(page, size),
                proveedoresPage.getTotalElements());

        return dtoPage;
    }

    @Override
    public String eliminarProveedor(String id) {
        try {
            proveedorRepository.deleteById(id);
            return "Operacion Exitosa";
        } catch (Exception e) {
            System.out.println("Erro Eliminar Proveedor " + e);
            return "Error al procesar la operacion";
        }
    }

    @Override
    public Long obtenerCantidadProveedores() {
        return proveedorRepository.count();
    }

}
