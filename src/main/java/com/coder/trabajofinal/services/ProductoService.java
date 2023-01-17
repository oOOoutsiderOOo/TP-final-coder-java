package com.coder.trabajofinal.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.trabajofinal.models.entities.Producto;
import com.coder.trabajofinal.repositories.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).get();
    }

    public List<Producto> findProductos(String searchQuery) {
        List<Producto> productos = productoRepository.findByNombreContainingIgnoreCase(searchQuery);
        productos.addAll(productoRepository.findByDescripcionContainingIgnoreCase(searchQuery));

        List<Producto> productosSinDuplicados = productos.stream().distinct().collect(Collectors.toList());

        return productosSinDuplicados;
    }

    public int getStock(long id) {
        return productoRepository.findById(id).get().getStock();
    }

    public void updateStock(long id, int cantidad) {
        Producto productoToUpdate = productoRepository.findById(id).get();
        productoToUpdate.setStock(productoToUpdate.getStock() - cantidad);
        productoRepository.save(productoToUpdate);
    }

    public Producto addNewProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
