package com.superCompras.service;

import com.superCompras.model.Carrito;

import java.util.List;

public interface CarritoServiceIF {

    //declaro los metodos a implementar en la clase CarritoServiceImpl
    public List<Carrito> listarRegistros();

    public void crearRegistro(Carrito obj);

    public void actualizarRegistro(Carrito obj);

    public void borrarRegistro(Long id);

    public Carrito registroPorId(Long id);


}
