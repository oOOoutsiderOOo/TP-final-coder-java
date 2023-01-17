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

import com.coder.trabajofinal.models.entities.ProductoVenta;
import com.coder.trabajofinal.services.ProductoVentaService;

@CrossOrigin()
@RestController
@RequestMapping("/api/productoVenta")
public class ProductoVentaController {
    @Autowired
    ProductoVentaService productoVentaService;

    @GetMapping("/todos")

    public ResponseEntity<?> getAllProductoVentas() {
        return ResponseEntity.ok(productoVentaService.getAllProductoVentas());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> addNewProductoVenta(@RequestBody ProductoVenta productoVenta) {

        return ResponseEntity.ok(productoVentaService.addNew(productoVenta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductoVenta(@PathVariable Long id) {
        productoVentaService.delete(id);
        return ResponseEntity.ok("ProductoVenta eliminado");
    }
}
