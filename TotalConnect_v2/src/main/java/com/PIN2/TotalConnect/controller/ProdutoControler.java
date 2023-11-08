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

import com.PIN2.TotalConnect.entity.Produto;
import com.PIN2.TotalConnect.entity.RespostaModelo;
import com.PIN2.TotalConnect.service.ProdutoService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProdutoControler {
    
    @Autowired
    private ProdutoService prodser;

    @PostMapping("/cadprod")
    public ResponseEntity<?> cadastrar(@RequestBody Produto p){
        return prodser.cadastrarProduto(p);
    }

    @GetMapping("/produtos")
    public Iterable<Produto> listar(){
        return prodser.listarTodosProd();
    }
    
    @PutMapping("/alterarprod")
    public ResponseEntity<?> alterar(@RequestBody Produto p){
        return prodser.alterarProduto(p);
    }

    @DeleteMapping("/delprod/{idProduto}")
    public ResponseEntity<RespostaModelo> removerProduto(@PathVariable Integer codigo){
        return prodser.removerProduto(codigo);
    }


}
