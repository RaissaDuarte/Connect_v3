package com.PIN2.TotalConnect.service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.DoubleAdder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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


    //entradas 
    // public ResponseEntity<?> atualizarEntradaEstoque(Integer id_produto, Map<String, Object> camposAtualizados) {
    //     Optional<Produto> produtoOptional = prodre.findById(id_produto);

    //     if (produtoOptional.isPresent()) {
    //         Produto produto = produtoOptional.get();

    //         if (camposAtualizados.containsKey("quantidade")) {
    //             Integer quantidade = (Integer) camposAtualizados.get("quantidade");
    //             Double novaQuantidade = produto.getQuantidade() + quantidade;
    //             produto.setQuantidade(novaQuantidade);
    //         }

    //         if (camposAtualizados.containsKey("valor")) {
    //             Double valor = (Double) camposAtualizados.get("valor");
    //             produto.setValor(valor);
    //         }

    //         return new ResponseEntity<>(prodre.save(produto), HttpStatus.OK);
    //     } else {
    //         remo.setMensagem("Produto não encontrado");
    //         return new ResponseEntity<>(remo, HttpStatus.NOT_FOUND);
    //     }
    // }


    
}
