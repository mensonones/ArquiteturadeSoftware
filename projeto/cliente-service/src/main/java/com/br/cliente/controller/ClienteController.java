package com.br.cliente.controller;

import com.br.cliente.model.Cliente;
import com.br.cliente.service.ClienteService;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente/new")
    public ResponseEntity<Cliente> createCliente(@Valid @RequestBody Cliente cliente) {
        Preconditions.checkNotNull(cliente);
        Cliente cliente1 = clienteService.addCliente(cliente);
        return new ResponseEntity<>(cliente1, HttpStatus.CREATED);

    }

    @PutMapping(value = "/cliente/update/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable("id") int id, @RequestBody Cliente cliente) {
        Cliente cliente1 = clienteService.getClienteById(id);

        cliente1.setNome(cliente.getNome());
        cliente1.setTelefone(cliente.getTelefone());
        final Cliente updatedCliente = clienteService.addCliente(cliente1);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/cliente/remove/{id}")
    public ResponseEntity removeCliente(@PathVariable(value = "id") int clienteId) {

        Cliente clienteEncontrado = clienteService.getClienteById(clienteId);
        if(clienteEncontrado==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        clienteService.deleteCliente(clienteId);
        return new ResponseEntity<Cliente>(HttpStatus.OK);
    }

    @GetMapping("/cliente/{id}")
    public Cliente viewClienteById(@PathVariable(value = "id") Integer clienteId) {

        return clienteService.getClienteById(clienteId);
    }

    @GetMapping("/cliente/all")
    public List<Cliente> viewAllClientes() {

        return clienteService.getAllClientes();
    }
}