package com.coder.trabajofinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coder.trabajofinal.models.entities.Comprobante;

public interface ComprobanteRepository extends JpaRepository<Comprobante, Long> {

}
