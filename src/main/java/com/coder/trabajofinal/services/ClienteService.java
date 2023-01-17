package com.coder.trabajofinal.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.trabajofinal.models.entities.Cliente;
import com.coder.trabajofinal.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> searchCliente(String searchQuery) {
        List<Cliente> clientes = clienteRepository.findByApellidoContainingIgnoreCase(searchQuery);
        clientes.addAll(clienteRepository.findByNombreContainingIgnoreCase(searchQuery));
        List<Cliente> clientesSinDuplicados = clientes.stream().distinct().collect(Collectors.toList());
        return clientesSinDuplicados;
    }

    public Cliente addNewCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Long id, Cliente cliente) {
        Cliente clienteToUpdate = clienteRepository.findById(id).get();
        clienteToUpdate.setNombre(cliente.getNombre());
        clienteToUpdate.setApellido(cliente.getApellido());
        clienteToUpdate.setDNI(cliente.getDNI());
        return clienteRepository.save(clienteToUpdate);
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
