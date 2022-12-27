package com.superCompras.service;

import com.superCompras.model.Carrito;
import com.superCompras.repository.ICarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoServiceImpl implements CarritoServiceIF{
     
    @Autowired      //inyectar la dependencia JpaRepositorio con: @Autowired
    public ICarritoRepository tablaRepo;    //al instanciar la clase ICarritoRepository, puedo usar los metodos de JpaRepository
   
    //Implementacion de los metodos de la Interfase "CarritoServiceIF"
    @Override
    public List<Carrito> listarRegistros() {
        return tablaRepo.findAll();
    }

    @Override
    public void crearRegistro(Carrito obj) {
        tablaRepo.save(obj);
    }
    
    @Override
    public void actualizarRegistro(Carrito obj) {
        tablaRepo.save(obj);
    }
    
    @Override
    public void borrarRegistro(Long id) {
        tablaRepo.deleteById(id);
    }

    @Override
    public Carrito registroPorId(Long id) {
        return tablaRepo.findById(id).orElse(null);
    }

}
