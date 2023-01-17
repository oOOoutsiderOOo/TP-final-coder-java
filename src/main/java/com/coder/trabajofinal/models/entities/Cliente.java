package com.coder.trabajofinal.models.entities;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "clienteId")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long clienteId;

    private long DNI;

    private String nombre;

    private String apellido;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Comprobante> comprobante;

    public Cliente() {
    }

    public Cliente(long clienteId, long DNI, String nombre, String apellido, List<Comprobante> comprobante) {
        this.clienteId = clienteId;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.comprobante = comprobante;
    }

    public long getClienteId() {
        return this.clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public long getDNI() {
        return this.DNI;
    }

    public void setDNI(long DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Comprobante> getComprobante() {
        return this.comprobante;
    }

    public void setComprobante(List<Comprobante> comprobante) {
        this.comprobante = comprobante;
    }

    public Cliente clienteId(long clienteId) {
        setClienteId(clienteId);
        return this;
    }

    public Cliente DNI(long DNI) {
        setDNI(DNI);
        return this;
    }

    public Cliente nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Cliente apellido(String apellido) {
        setApellido(apellido);
        return this;
    }

    public Cliente comprobante(List<Comprobante> comprobante) {
        setComprobante(comprobante);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return clienteId == cliente.clienteId && DNI == cliente.DNI && Objects.equals(nombre, cliente.nombre)
                && Objects.equals(apellido, cliente.apellido) && Objects.equals(comprobante, cliente.comprobante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteId, DNI, nombre, apellido, comprobante);
    }

    @Override
    public String toString() {
        return "{" +
                " clienteId='" + getClienteId() + "'" +
                ", DNI='" + getDNI() + "'" +
                ", nombre='" + getNombre() + "'" +
                ", apellido='" + getApellido() + "'" +
                ", comprobante='" + getComprobante() + "'" +
                "}";
    }

}
