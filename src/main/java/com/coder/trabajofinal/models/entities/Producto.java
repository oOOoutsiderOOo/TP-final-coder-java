package com.coder.trabajofinal.models.entities;

import java.util.List;
import java.util.Objects;

import com.coder.trabajofinal.utils.ProductoSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
@JsonSerialize(using = ProductoSerializer.class)

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productoId;

    private long codigo;

    private String nombre;

    private String descripcion;

    private int stock;

    private double precio;

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ProductoVenta> productoVenta;

    public Producto() {
    }

    public Producto(long productoId, long codigo, String nombre, String descripcion, int stock, double precio,
            List<ProductoVenta> productoVenta) {
        this.productoId = productoId;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.productoVenta = productoVenta;
    }

    public long getProductoId() {
        return this.productoId;
    }

    public void setProductoId(long productoId) {
        this.productoId = productoId;
    }

    public long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<ProductoVenta> getProductoVenta() {
        return this.productoVenta;
    }

    public void setProductoVenta(List<ProductoVenta> productoVenta) {
        this.productoVenta = productoVenta;
    }

    public Producto productoId(long productoId) {
        setProductoId(productoId);
        return this;
    }

    public Producto codigo(long codigo) {
        setCodigo(codigo);
        return this;
    }

    public Producto nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Producto descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    public Producto stock(int stock) {
        setStock(stock);
        return this;
    }

    public Producto precio(double precio) {
        setPrecio(precio);
        return this;
    }

    public Producto productoVenta(List<ProductoVenta> productoVenta) {
        setProductoVenta(productoVenta);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Producto)) {
            return false;
        }
        Producto producto = (Producto) o;
        return productoId == producto.productoId && codigo == producto.codigo && Objects.equals(nombre, producto.nombre)
                && Objects.equals(descripcion, producto.descripcion) && stock == producto.stock
                && precio == producto.precio && Objects.equals(productoVenta, producto.productoVenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId, codigo, nombre, descripcion, stock, precio, productoVenta);
    }

    @Override
    public String toString() {
        return "{" +
                " productoId='" + getProductoId() + "'" +
                ", codigo='" + getCodigo() + "'" +
                ", nombre='" + getNombre() + "'" +
                ", descripcion='" + getDescripcion() + "'" +
                ", stock='" + getStock() + "'" +
                ", precio='" + getPrecio() + "'" +
                ", productoVenta='" + getProductoVenta() + "'" +
                "}";
    }

}
