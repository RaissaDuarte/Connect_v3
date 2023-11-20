package com.PIN2.TotalConnect.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.PIN2.TotalConnect.entity.Cliente;
import com.PIN2.TotalConnect.entity.Produto;
import com.PIN2.TotalConnect.entity.RespostaModelo;
import com.PIN2.TotalConnect.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RespostaModelo respostaModelo;

    public Iterable<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    public ResponseEntity<?> cadastrarCliente(Cliente cliente) {
        if (cliente.getNome().equals("")) {
            respostaModelo.setMensagem("Campo nome está vazio");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Cliente>(clienteRepository.save(cliente), HttpStatus.CREATED);
        }
    }

    public Optional<Cliente> buscarClientePorId(Integer id_cliente) {
        return clienteRepository.findById(id_cliente);
    }

    public ResponseEntity<?> alterarCliente(Cliente cliente) {
        return new ResponseEntity<Cliente>(clienteRepository.save(cliente), HttpStatus.OK);
    }

    public ResponseEntity<RespostaModelo> removerCliente(Integer id) {
        clienteRepository.deleteById(id);
        respostaModelo.setMensagem("Cliente removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }
}
