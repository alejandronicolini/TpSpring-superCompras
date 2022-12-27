package com.superCompras.controller;

import com.superCompras.model.Carrito;
import com.superCompras.model.Producto;
import com.superCompras.service.CarritoServiceIF;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/carrito")
public class ControllerCarrito {

    @Autowired
    private CarritoServiceIF carritoService;

    @GetMapping("/listado")
    @ResponseBody
    @ApiOperation("Listado de carritos de compras en la base de datos")
    public ResponseEntity<List<Carrito>> listado() {
        List<Carrito> obj = carritoService.listarRegistros();
        return new ResponseEntity<List<Carrito>>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}/totalCompra")
    @ApiOperation("Consulta el monto total del carrito de compras por ID")
    public String montoCompra(@PathVariable("id") Long id) {
        Carrito chango = carritoService.registroPorId(id);
        double monto = chango.totalMontoCarrito();
        if (monto ==0.00){
            return  "El carrito esta vacío";
        }
        else {
            return "El monto total de la compra es de: $ "+String.valueOf(monto);
        }
    }

    @PostMapping("/new")
    @ApiOperation("Creación de un carrito de compras vacío")
    public void agregar(@RequestBody Carrito obj) { //el @RequestBody transforma el .json en objeto "obj"
        obj.setProductosLista(Collections.emptyList());
        carritoService.crearRegistro(obj);
    }

    @PostMapping("/new2")
    @ApiOperation("Creación de un carrito de compras con productos")
    public void agregarPrueba(@RequestBody Carrito obj) {
        carritoService.crearRegistro(obj);
        if (obj.getProductosLista().isEmpty()){
            Carrito chango = carritoService.registroPorId(obj.getId_carrito());
            for (Producto producto:obj.getProductosLista()) {
                producto.setCarritoProductos(chango);
                chango.addproducto(producto);
            }
        }
    }

    @PutMapping("/{id}/addProducto")
    @ApiOperation("Agregar un producto al carrito de compras")
    public void agregarProducto(@RequestBody Producto producto, @PathVariable("id") Long id) {
        Carrito chango = carritoService.registroPorId(id);
        producto.setCarritoProductos(chango);
        chango.addproducto(producto);
    }

    @PutMapping("/{id}/addProductoV2")
    @ResponseBody
    @ApiOperation("Agregar un producto al carrito de compras V2")
    public ResponseEntity<Carrito> agregarProducto2(@RequestBody Producto producto, @PathVariable("id") Long id) {
        Carrito chango = carritoService.registroPorId(id);
        producto.setCarritoProductos(chango); //fundamental esta instruccion
        chango.addproducto(producto);
        return new ResponseEntity<Carrito>(chango, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Actualizar todo el carrito de compras")
    public void actualizar(@RequestBody Carrito obj, @PathVariable("id") Long id) {
        obj.setId_carrito(id); //fundamental esta instruccion
        carritoService.actualizarRegistro(obj);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Eliminar el carrito de compras y los producto de la BD")
    public void borrar(@PathVariable("id") Long id) {
        carritoService.borrarRegistro(id);
    }

    @GetMapping("/{id}")
    @ApiOperation("Consulta contenido de carrito de compras por su ID")
    public Carrito consultarPorId(@PathVariable("id") Long id) {
        return carritoService.registroPorId(id);
    }

}
