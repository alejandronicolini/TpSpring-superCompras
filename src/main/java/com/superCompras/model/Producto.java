package com.superCompras.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "productos")
@ApiModel("Clase Producto: entidad que representar un articulo a comprar e ingresar en el Chango")
public class Producto {

    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave primaria autoincremental tipo Long")
    private Long id_producto;

    @Column(name = "nombre", nullable = false, length = 50)
    @ApiModelProperty("Nombre del Articulo")
    private String nombre;

    @Column(name = "categoria", nullable = false, length = 30)
    private String categoria;

    @Column(name = "subcategoria", length = 30)
    private String subcategoria;

    @Column(name = "descripcion", length = 50)
    private String descripcion;

    @ApiModelProperty("Precio en pesos argentinos, con 2 decimales, utilizando el . punto como separador")
    @Column(name = "precio", nullable = false, scale = 2)
    private double precio;

    @ApiModelProperty("Cantidad de productos, numero entero o con 2 decimales, utilizando el . punto como separador")
    @Column(name = "cantidad", nullable = false, scale = 2)
    private double cantidad;

    @Column(name = "tamanio", columnDefinition = "INT(10)")
    private int tamanio;

    @Column(name = "tipo", length = 150)
    private String tipo;

    @Lob
    @Column(name = "foto", columnDefinition = "LONGTEXT")
    private String foto;

    @ManyToOne
    @JoinColumn(name = "id_chango")
    @JsonIgnore
    private Carrito carritoProductos;


    //Constructores
    public Producto() {
    }

    public Producto(String nombre, String categoria, String subcategoria, String descripcion, double precio, double cantidad, int tamanio, String tipo, String foto, Carrito carritoProductos) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tamanio = tamanio;
        this.tipo = tipo;
        this.foto = foto;
        this.carritoProductos = carritoProductos;
    }

    public Producto(String nombre, String categoria, String subcategoria, String descripcion, double precio, double cantidad, int tamanio, String tipo, String foto) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tamanio = tamanio;
        this.tipo = tipo;
        this.foto = foto;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

}
