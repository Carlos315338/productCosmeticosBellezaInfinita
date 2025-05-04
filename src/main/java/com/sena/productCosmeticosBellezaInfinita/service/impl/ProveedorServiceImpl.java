package com.sena.productCosmeticosBellezaInfinita.service.impl;

import com.sena.productCosmeticosBellezaInfinita.dto.PaginacionFiltroDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProveedorDTO;
import com.sena.productCosmeticosBellezaInfinita.dto.ProveedorSelectDTO;
import com.sena.productCosmeticosBellezaInfinita.entity.Proveedor;
import com.sena.productCosmeticosBellezaInfinita.mapper.ProveedorMapper;
import com.sena.productCosmeticosBellezaInfinita.repository.ProveedorRepository;
import com.sena.productCosmeticosBellezaInfinita.service.ProveedorService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public Page<ProveedorDTO> obtenerProveedores(PaginacionFiltroDTO filtro) {

        Sort sort = "desc".equalsIgnoreCase(filtro.getSortOrder())
                ? Sort.by(filtro.getSortField()).descending()
                : Sort.by(filtro.getSortField()).ascending();

        Pageable pageable = PageRequest.of(filtro.getPage(), filtro.getSize(), sort);

        Page<Proveedor> proveedoresPage;

        if (filtro.getNombre() != null && !filtro.getNombre().trim().isEmpty()) {
            proveedoresPage = proveedorRepository.findByNombreProveedorContainingIgnoreCase(filtro.getNombre(),
                    pageable);
        } else {
            proveedoresPage = proveedorRepository.findAll(pageable);
        }

        List<ProveedorDTO> proveedorDTOs = proveedorMapper
                .listProveedorToListProveedorDTO(proveedoresPage.getContent());

        return new PageImpl<>(proveedorDTOs, pageable, proveedoresPage.getTotalElements());
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

    @Override
    public ProveedorDTO actualizacionProveedor(String id, ProveedorDTO proveedorDTO) {
        Proveedor proveedorExistente = proveedorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Proveedor no encontrado con ID: " + id));

        proveedorExistente.setNitProveedor(proveedorDTO.getNitProveedor());
        proveedorExistente.setNombreProveedor(proveedorDTO.getNombreProveedor());
        proveedorExistente.setCorreoElectronico(proveedorDTO.getCorreoElectronico());
        proveedorExistente.setTelefono(proveedorDTO.getTelefono());

        Proveedor actualizado = proveedorRepository.save(proveedorExistente);
        return proveedorMapper.proveedorToProveedorDTO(actualizado);
    }
}
