package com.coder.trabajofinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.trabajofinal.models.entities.Producto;
import com.coder.trabajofinal.services.ProductoService;

@CrossOrigin()
@RestController
@RequestMapping(value = "/api/productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("")
    public ResponseEntity<?> getAllProductos() {
        if (productoService.getAllProductos().isEmpty()) {
            return ResponseEntity.badRequest().body("No hay productos cargados");
        }
        return ResponseEntity.ok(productoService.getAllProductos());
    }

    @GetMapping("/{searchQuery}")
    public ResponseEntity<?> getProductos(@PathVariable String searchQuery) {
        return ResponseEntity.ok(productoService.findProductos(searchQuery));
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> addNewCliente(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.addNewProducto(producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return ResponseEntity.ok("Producto eliminado");
    }
}
