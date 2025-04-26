package com.sena.productCosmeticosBellezaInfinita.service.impl;

import com.sena.productCosmeticosBellezaInfinita.dto.CategoriaSelectDTO;
import com.sena.productCosmeticosBellezaInfinita.mapper.CategoriaMapper;
import com.sena.productCosmeticosBellezaInfinita.repository.CategoriaRepository;
import com.sena.productCosmeticosBellezaInfinita.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository proveedorRepository;

    @Autowired
    private CategoriaMapper proveedorMapper;

    @Override
    public List<CategoriaSelectDTO> obtenerProveedoresParaSelect() {
        return proveedorMapper.listCategoriaToCategoriaSelectDTO(proveedorRepository.findAll());
    }

    @Override
    public Long obtenerCantidadCategoria() {
        return proveedorRepository.count();
    }
}
