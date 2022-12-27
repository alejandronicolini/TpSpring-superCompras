package com.superCompras.service;

import com.superCompras.model.Producto;

import java.util.List;

public interface ProductosServiceIF {

    public List<Producto> listarRegistros();

    public void crearRegistro(Producto obj);

    public void actualizarRegistro(Producto obj);

    public void borrarRegistro(Long id);

    public Producto registroPorId(Long id);

}
