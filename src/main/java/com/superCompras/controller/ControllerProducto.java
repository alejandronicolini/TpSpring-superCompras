package com.superCompras.controller;

import com.superCompras.model.Carrito;
import com.superCompras.model.Producto;
import com.superCompras.service.CarritoServiceIF;
import com.superCompras.service.ProductosServiceIF;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping ("/productos")
public class ControllerProducto {
    
    @Autowired
    private ProductosServiceIF productoService;
    
    @Autowired
    private CarritoServiceIF carritoService;
    
    
    @GetMapping("/listado")
    @ResponseBody
    @ApiOperation("Listado de productos en la base de datos")
    public List <Producto> listado(){
        return  productoService.listarRegistros();
    }
    
    @PostMapping("/new")
    @ApiOperation("Creación de un producto")
    public void agregar (@RequestBody Producto obj){
        long idCarrito = 1;
        Carrito objTemporal = carritoService.registroPorId(idCarrito); //llamo al chango de la tabla Carrito
        obj.setCarritoProductos(objTemporal); //le seteo el carrito al producto que viene del FrontEnd
                
        productoService.crearRegistro(obj);
    }
    
    @PutMapping("/update/{id}")
    @ApiOperation("Actualizar información de un Producto existente, por su ID")
    public void actualizar (@RequestBody Producto obj, @PathVariable("id") Long id){
        obj.setId_producto(id);
        productoService.actualizarRegistro(obj);
    }
    
    @DeleteMapping ("/delete/{id}")
    @ApiOperation("Eliminar el producto de la BD")
    public void borrar (@PathVariable ("id") Long id){
        productoService.borrarRegistro(id);
    } 
    
    @GetMapping("/{id}")
    @ApiOperation("Consultar un producto por su ID")
    public Producto consultarPorId(@PathVariable("id") Long id){
        return  productoService.registroPorId(id);
    }

}
