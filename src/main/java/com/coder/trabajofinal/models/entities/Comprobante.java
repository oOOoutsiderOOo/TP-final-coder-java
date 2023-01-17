package com.coder.trabajofinal.models.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.coder.trabajofinal.utils.ComprobanteSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "comprobante")
@JsonSerialize(using = ComprobanteSerializer.class)
public class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long comprobanteId;

    private LocalDate fecha;

    private Double total;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "comprobante", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.REMOVE)
    private List<ProductoVenta> productoVenta;

    public Comprobante() {
    }

    public Comprobante(long comprobanteId, LocalDate fecha, Double total, Cliente cliente,
            List<ProductoVenta> productoVenta) {
        this.comprobanteId = comprobanteId;
        this.fecha = fecha;
        this.total = total;
        this.cliente = cliente;
        this.productoVenta = productoVenta;
    }

    public long getComprobanteId() {
        return this.comprobanteId;
    }

    public void setComprobanteId(long comprobanteId) {
        this.comprobanteId = comprobanteId;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return this.total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ProductoVenta> getProductoVenta() {
        return this.productoVenta;
    }

    public void setProductoVenta(List<ProductoVenta> productoVenta) {
        this.productoVenta = productoVenta;
    }

    public void addProductoVenta(ProductoVenta productoVenta) {
        this.productoVenta.add(productoVenta);
        // productoVenta.setComprobante(this);
    }

    public Comprobante comprobanteId(long comprobanteId) {
        setComprobanteId(comprobanteId);
        return this;
    }

    public Comprobante fecha(LocalDate fecha) {
        setFecha(fecha);
        return this;
    }

    public Comprobante total(Double total) {
        setTotal(total);
        return this;
    }

    public Comprobante cliente(Cliente cliente) {
        setCliente(cliente);
        return this;
    }

    public Comprobante productoVenta(List<ProductoVenta> productoVenta) {
        setProductoVenta(productoVenta);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Comprobante)) {
            return false;
        }
        Comprobante comprobante = (Comprobante) o;
        return comprobanteId == comprobante.comprobanteId && Objects.equals(fecha, comprobante.fecha)
                && total == comprobante.total && Objects.equals(cliente, comprobante.cliente)
                && Objects.equals(productoVenta, comprobante.productoVenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comprobanteId, fecha, total, cliente, productoVenta);
    }

    @Override
    public String toString() {
        return "{" +
                " comprobanteId='" + getComprobanteId() + "'" +
                ", fecha='" + getFecha() + "'" +
                ", total='" + getTotal() + "'" +
                ", cliente='" + getCliente() + "'" +
                ", productoVenta='" + getProductoVenta() + "'" +
                "}";
    }

}
