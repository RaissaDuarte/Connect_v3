package com.PIN2.TotalConnect.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.PIN2.TotalConnect.entity.Produto;
import com.PIN2.TotalConnect.entity.RespostaModelo;
import com.PIN2.TotalConnect.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository prodre;

    @Autowired
    private RespostaModelo remo;

    //listar
    public Iterable<Produto> listarTodosProd(){
        return prodre.findAll();
    }
    
    //cadastrar
    public ResponseEntity<?> cadastrarProduto(Produto p){
        
        if(p.getNome().equals("")){
            remo.setMensagem("Campo nome está vazio");
            return new ResponseEntity<RespostaModelo>(remo, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<Produto>(prodre.save(p), HttpStatus.CREATED);
        }
    }

    //alterar
    public ResponseEntity<?> alterarProduto(Produto p){
        
        if(p.getNome().equals("")){
            remo.setMensagem("Campo nome está vazio");
            return new ResponseEntity<RespostaModelo>(remo, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<Produto>(prodre.save(p), HttpStatus.OK);
        }
    }

    

    public Optional<Produto> buscarProdutoPorId(Integer id_produto) {
        return prodre.findById(id_produto);
    }

    public ResponseEntity<RespostaModelo> removerProduto(Integer codigo){
        prodre.deleteById(codigo);
        remo.setMensagem("Produto removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(remo, HttpStatus.OK);
    }
}
