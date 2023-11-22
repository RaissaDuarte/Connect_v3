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

    @GetMapping("/produtos/{id_produto}")
    public ResponseEntity<?> buscarProdutoPorId(@PathVariable("id_produto") Integer id_produto) {
    Optional<Produto> produto = prodser.buscarProdutoPorId(id_produto);
    if (produto.isPresent()) {
        return new ResponseEntity<>(produto.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);
    }
}
    
    @PutMapping("/alterarprod")
    public ResponseEntity<?> alterar(@RequestBody Produto p){
        return prodser.alterarProduto(p);
    }

    @DeleteMapping("/delprod/{id_produto}")
    public ResponseEntity<RespostaModelo> removerProduto(@PathVariable("id_produto") Integer id_produto){
        return prodser.removerProduto(id_produto);
    }
}
