package com.PIN2.TotalConnect.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PIN2.TotalConnect.entity.Cliente;
import com.PIN2.TotalConnect.entity.RespostaModelo;
import com.PIN2.TotalConnect.service.ClienteService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadcliente")
    public ResponseEntity<?> cadastrar(@RequestBody Cliente c) {
        return clienteService.cadastrarCliente(c);
    }

    @GetMapping("/clientes")
    public Iterable<Cliente> listar() {
        return clienteService.listarTodosClientes();
    }

    @GetMapping("/clientes/{id_cliente}")
    public ResponseEntity<?> buscarClientePorId(@PathVariable("id_cliente") Integer id_cliente) {
    Optional<Cliente> cliente = clienteService.buscarClientePorId(id_cliente);
    if (cliente.isPresent()) {
        return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);
    }
    }

    @PutMapping("/alterarcliente")
    public ResponseEntity<?> alterar(@RequestBody Cliente cliente) {
        return clienteService.alterarCliente(cliente);
    }

    @DeleteMapping("/delcliente/{id_cliente}")
    public ResponseEntity<RespostaModelo> removerCliente(@PathVariable Integer id_cliente) {
        return clienteService.removerCliente(id_cliente);
    }
}
