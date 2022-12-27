package com.superCompras.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "carrito") //nombre de la tabla en la BD
@ApiModel("Clase Carrito: entidad que representa el vinculo con los articulos a comprar")
public class Carrito {

    @Id
    @Column(name = "id_carrito")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave primaria autoincremental tipo Long")
    private Long id_carrito;

    @OneToMany(mappedBy = "carritoProductos", cascade = CascadeType.ALL)
    @ApiModelProperty("Lista de productos que contiene el carrito")
    private List<Producto> productosLista; // "carritoProductos" es el atributo de la clase Producto

    //Constructores
    public Carrito() {
    }

    public Carrito(List<Producto> productosLista) {
        this.productosLista = productosLista;
    }

    //Getters y Setters uso Lombok
    public Long getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Long idCarrito) {
        this.id_carrito = idCarrito;
    }

    public void addproducto(Producto objProducto) {
        if (productosLista == null) {
            productosLista = new ArrayList<>(); //instancio la lista si no existe
        }
        this.productosLista.add(objProducto); //agrego objProducto a la lista
        objProducto.setCarritoProductos(this); //seteo el Carrito en la clase Producto
    }

    public void removeProducto(Producto objProducto) {
        this.productosLista.remove(objProducto);
        objProducto.setCarritoProductos(null);
    }

    public double totalMontoCarrito() {
        double parcial = 0.00;
        for (Producto elem : productosLista) {
            parcial += elem.getCantidad() * elem.getPrecio();
        }
        return parcial;
    }

}
