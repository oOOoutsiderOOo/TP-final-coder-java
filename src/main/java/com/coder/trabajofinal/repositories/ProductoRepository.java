package com.coder.trabajofinal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coder.trabajofinal.models.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    List<Producto> findByDescripcionContainingIgnoreCase(String descripcion);

}
