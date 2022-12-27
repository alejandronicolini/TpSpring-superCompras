package com.superCompras.service;

import com.superCompras.model.Producto;
import com.superCompras.repository.IProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServiceImpl implements ProductosServiceIF {
    
    @Autowired
    public IProductosRepository tablaRepo;

    @Override
    public List<Producto> listarRegistros() {
        return  tablaRepo.findAll();
    }

    @Override
    public void crearRegistro(Producto obj) {
        tablaRepo.save(obj);
    }

    @Override
    public void actualizarRegistro(Producto obj) {
        tablaRepo.save(obj);
    }

    @Override
    public void borrarRegistro(Long id) {
        tablaRepo.deleteById(id);
    }

    @Override
    public Producto registroPorId(Long id) {
        return tablaRepo.findById(id).orElse(null);
    }

}
