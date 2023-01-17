package com.coder.trabajofinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.trabajofinal.models.entities.Comprobante;
import com.coder.trabajofinal.repositories.ComprobanteRepository;

@Service
public class ComprobanteService {

    @Autowired
    private ComprobanteRepository comprobanteRepository;

    public List<Comprobante> getAllComprobantes() {
        return comprobanteRepository.findAll();
    }

    public Comprobante addNewComprobante(Comprobante comprobante) {
        return comprobanteRepository.save(comprobante);
    }

    public void deleteComprobante(Long id) {
        comprobanteRepository.deleteById(id);
    }

}
