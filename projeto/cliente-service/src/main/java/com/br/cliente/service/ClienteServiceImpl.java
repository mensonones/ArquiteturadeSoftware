package com.br.cliente.service;

import com.br.cliente.model.Cliente;
import com.br.cliente.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

     private ClienteRepository clienteRepository;

     public ClienteServiceImpl(ClienteRepository clienteRepository){
         this.clienteRepository = clienteRepository;
     }

    @Override
    public List<Cliente> getAllClientes() {
         return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(Integer id) {
         return clienteRepository.getClienteById(id);
    }

    @Override
    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(int id) {
        clienteRepository.deleteById(id);
    }
}
