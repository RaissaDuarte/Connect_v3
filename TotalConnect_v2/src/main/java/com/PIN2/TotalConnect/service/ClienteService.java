package com.PIN2.TotalConnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.PIN2.TotalConnect.entity.Cliente;
import com.PIN2.TotalConnect.entity.RespostaModelo;
import com.PIN2.TotalConnect.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RespostaModelo respostaModelo;

    // Listar todos os clientes
    public Iterable<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    // Cadastrar um novo cliente
    public ResponseEntity<?> cadastrarCliente(Cliente cliente) {
        if (cliente.getNome().equals("")) {
            respostaModelo.setMensagem("Campo nome está vazio");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Cliente>(clienteRepository.save(cliente), HttpStatus.CREATED);
        }
    }

    // Alterar informações de um cliente
    public ResponseEntity<?> alterarCliente(Cliente cliente) {
        return new ResponseEntity<Cliente>(clienteRepository.save(cliente), HttpStatus.OK);
    }

    // Remover um cliente
    public ResponseEntity<RespostaModelo> removerCliente(Integer id) {
        clienteRepository.deleteById(id);
        respostaModelo.setMensagem("Cliente removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }
}
