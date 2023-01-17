package com.coder.trabajofinal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coder.trabajofinal.models.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByApellidoContainingIgnoreCase(String searchQuery);

    List<Cliente> findByNombreContainingIgnoreCase(String searchQuery);

}
