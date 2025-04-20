package com.sena.productCosmeticosBellezaInfinita.service.impl;

import com.sena.productCosmeticosBellezaInfinita.dto.ProveedorSelectDTO;
import com.sena.productCosmeticosBellezaInfinita.mapper.ProveedorMapper;
import com.sena.productCosmeticosBellezaInfinita.repository.ProveedorRepository;
import com.sena.productCosmeticosBellezaInfinita.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService  {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ProveedorMapper proveedorMapper;

    @Override
    public List<ProveedorSelectDTO> obtenerProveedoresParaSelect() {
        return proveedorMapper.listProveedorToProveedorSelectDTO(proveedorRepository.findAll());
    }
}
