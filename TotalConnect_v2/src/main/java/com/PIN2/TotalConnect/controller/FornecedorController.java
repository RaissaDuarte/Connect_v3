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

import com.PIN2.TotalConnect.entity.Fornecedor;
import com.PIN2.TotalConnect.entity.RespostaModelo;
import com.PIN2.TotalConnect.service.FornecedorService;

@RestController
@CrossOrigin("http://localhost:3000")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping("/cadfornec")
    public ResponseEntity<?> cadastrar(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.cadastrarFornecedor(fornecedor);
    }

    @GetMapping("/fornecedores")
    public Iterable<Fornecedor> listar() {
        return fornecedorService.listarTodosFornecedores();
    }

    @PutMapping("/alterarfornec")
    public ResponseEntity<?> alterar(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.alterarFornecedor(fornecedor);
    }

    @DeleteMapping("/delfornec/{id}")
    public ResponseEntity<RespostaModelo> removerFornecedor(@PathVariable Integer id) {
        return fornecedorService.removerFornecedor(id);
    }
}
