package com.coder.trabajofinal.controllers;

import java.time.LocalDate;

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

import com.coder.trabajofinal.models.Comprobante;
import com.coder.trabajofinal.models.ProductoVenta;
import com.coder.trabajofinal.services.ClienteService;
import com.coder.trabajofinal.services.ComprobanteService;
import com.coder.trabajofinal.services.ProductoService;
import com.coder.trabajofinal.services.ProductoVentaService;

@CrossOrigin()
@RestController
@RequestMapping(value = "/api/comprobantes")
public class ComprobanteController {

    @Autowired
    ComprobanteService comprobanteService;
    @Autowired
    ClienteService clienteService;
    @Autowired
    ProductoService productoService;
    @Autowired
    ProductoVentaService productoVentaService;

    @GetMapping("")
    public ResponseEntity<?> getAllComprobantes() {
        return ResponseEntity.ok(comprobanteService.getAllComprobantes());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> addNewComprobante(@RequestBody Comprobante comprobante) {
        if (comprobante.getCliente() == null) {
            return ResponseEntity.badRequest().body("El id del cliente es requerido");
        } else if (clienteService.getClienteById(comprobante.getCliente().getClienteId()) == null) {
            return ResponseEntity.badRequest().body("El cliente no existe");
        } else if (comprobante.getProductoVenta().size() == 0) {
            return ResponseEntity.badRequest().body("El comprobante debe contener al menos un producto");
        } else if (comprobante.getProductoVenta().stream()
                .anyMatch(p -> productoService.getProductoById(p.getProducto().getProductoId()) == null)) {
            return ResponseEntity.badRequest().body("Uno o más productos no existen");
        } else if (comprobante.getProductoVenta().stream()
                .anyMatch(p -> p.getCantidad() > productoService.getStock(p.getProducto().getProductoId()))) {
            return ResponseEntity.badRequest().body("Uno o más productos no tienen stock suficiente");
        } else if (comprobante.getProductoVenta().stream().anyMatch(p -> p.getCantidad() <= 0)) {
            return ResponseEntity.badRequest().body("Uno o más productos tienen una cantidad inválida");
        }

        else {

            comprobante.setFecha(LocalDate.now());
            Double total = 0.0;
            for (ProductoVenta p : comprobante.getProductoVenta()) {
                total += p.getProducto().getPrecio() * p.getCantidad();
            }
            comprobante.setTotal(comprobante.getProductoVenta().stream().mapToDouble(p -> {
                return (p.getCantidad() * productoService.getProductoById(p.getProducto().getProductoId()).getPrecio());
            }).sum());
            Comprobante comprobanteCreado = comprobanteService.addNewComprobante(comprobante);
            comprobante.getProductoVenta().stream().forEach(p -> {
                p.setComprobante(comprobanteCreado);
                p.setPrecio(p.getProducto().getPrecio());
                productoVentaService.addNew(p);
                productoService.updateStock(p.getProducto().getProductoId(), p.getCantidad());
            });

            return ResponseEntity.ok(comprobanteCreado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComprobante(@PathVariable Long id) {
        comprobanteService.deleteComprobante(id);
        return ResponseEntity.ok("Comprobante eliminado");
    }
}
