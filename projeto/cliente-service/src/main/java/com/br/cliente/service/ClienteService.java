package com.br.cliente.service;

import com.br.cliente.model.Cliente;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteService {

    public List<Cliente> getAllClientes();

    public Cliente getClienteById(Integer id);

    public Cliente addCliente(Cliente cliente);

    public Cliente updateCliente(Cliente cliente);

    public void deleteCliente(int id);

}
