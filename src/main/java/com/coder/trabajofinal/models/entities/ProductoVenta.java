package com.coder.trabajofinal.models.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto_venta")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "productoVentaId")
public class ProductoVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productoVentaId;

    private int cantidad;

    private Double precio;

    @ManyToOne
    private Comprobante comprobante;

    @ManyToOne
    private Producto producto;

    public ProductoVenta() {
    }

    public ProductoVenta(long productoVentaId, int cantidad, Double precio, Comprobante comprobante,
            Producto producto) {
        this.productoVentaId = productoVentaId;
        this.cantidad = cantidad;
        this.precio = precio;
        this.comprobante = comprobante;
        this.producto = producto;
    }

    public long getProductoVentaId() {
        return this.productoVentaId;
    }

    public void setProductoVentaId(long productoVentaId) {
        this.productoVentaId = productoVentaId;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Comprobante getComprobante() {
        return this.comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ProductoVenta productoVentaId(long productoVentaId) {
        setProductoVentaId(productoVentaId);
        return this;
    }

    public ProductoVenta cantidad(int cantidad) {
        setCantidad(cantidad);
        return this;
    }

    public ProductoVenta precio(Double precio) {
        setPrecio(precio);
        return this;
    }

    public ProductoVenta comprobante(Comprobante comprobante) {
        setComprobante(comprobante);
        return this;
    }

    public ProductoVenta producto(Producto producto) {
        setProducto(producto);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProductoVenta)) {
            return false;
        }
        ProductoVenta productoVenta = (ProductoVenta) o;
        return productoVentaId == productoVenta.productoVentaId && cantidad == productoVenta.cantidad
                && Objects.equals(precio, productoVenta.precio)
                && Objects.equals(comprobante, productoVenta.comprobante)
                && Objects.equals(producto, productoVenta.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoVentaId, cantidad, precio, comprobante, producto);
    }

    @Override
    public String toString() {
        return "{" +
                " productoVentaId='" + getProductoVentaId() + "'" +
                ", cantidad='" + getCantidad() + "'" +
                ", precio='" + getPrecio() + "'" +
                ", comprobante='" + getComprobante() + "'" +
                ", producto='" + getProducto() + "'" +
                "}";
    }

}
