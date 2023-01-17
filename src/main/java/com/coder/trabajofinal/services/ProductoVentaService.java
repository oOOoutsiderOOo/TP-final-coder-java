package com.coder.trabajofinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.trabajofinal.models.entities.ProductoVenta;
import com.coder.trabajofinal.repositories.ProductoVentaRepository;

@Service
public class ProductoVentaService {

    @Autowired
    ProductoVentaRepository productoVentaRepository;

    public List<ProductoVenta> getAllProductoVentas() {
        return productoVentaRepository.findAll();
    }

    public ProductoVenta addNew(ProductoVenta productoVenta) {
        return productoVentaRepository.save(productoVenta);
    }

    public void delete(Long id) {
        productoVentaRepository.deleteById(id);
    }

}
