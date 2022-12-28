package com.coder.trabajofinal.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.trabajofinal.models.Cliente;
import com.coder.trabajofinal.services.ClienteService;

@CrossOrigin()
@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("")
    public ResponseEntity<?> getAllClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public Optional<Cliente> getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    @GetMapping("/buscar/{searchQuery}")
    public ResponseEntity<?> searchCliente(@PathVariable String searchQuery) {
        return ResponseEntity.ok(clienteService.searchCliente(searchQuery));
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> addNew(@RequestBody Cliente cliente) {
        if (cliente.getNombre().isEmpty() || cliente.getApellido().isEmpty() || cliente.getDNI() <= 0) {
            return ResponseEntity.badRequest().body("El nombre, el apellido y el dni son obligatorios");
        }
        return ResponseEntity.ok(clienteService.addNewCliente(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.update(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.ok("Cliente eliminado");
    }

}
