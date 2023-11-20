package com.PIN2.TotalConnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<?> cadastrar(@RequestBody Cliente cliente) {
        return clienteService.cadastrarCliente(cliente);
    }

    @GetMapping("/clientes")
    public Iterable<Cliente> listar() {
        return clienteService.listarTodosClientes();
    }

    @GetMapping("/clientes/edit/{id}")
    public ResponseEntity<Cliente> obterClientePorId(@PathVariable Integer id) {
        Cliente cliente = clienteService.obterClientePorId(id);

        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/alterarcliente")
    public ResponseEntity<?> alterar(@RequestBody Cliente cliente) {
        return clienteService.alterarCliente(cliente);
    }

    @DeleteMapping("/clientes/delete/{idCliente}")
    public ResponseEntity<RespostaModelo> removerCliente(@PathVariable Integer idCliente) {
        return clienteService.removerCliente(idCliente);
    }
}
