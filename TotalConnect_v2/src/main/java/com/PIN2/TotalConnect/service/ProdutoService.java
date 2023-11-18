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
    //public ResponseEntity<?> alterarProduto(@PathVariable("id_produto") Integer id_produto, @RequestBody Produto novoProduto){
        
        //Optional<Produto> produtoExistente = prodre.findById(id_produto);

        // if (produtoExistente.isPresent() && novoProduto != null) {
        //     Produto produtoAtual = produtoExistente.get();
    
        //     produtoAtual.setNome(novoProduto.getNome());
        //     produtoAtual.setPeso(novoProduto.getPeso());
        //     produtoAtual.setDimensao(novoProduto.getDimensao());
        //     produtoAtual.setImagem(novoProduto.getImagem());
        //     produtoAtual.setQuantidade(novoProduto.getQuantidade());
        //     produtoAtual.setValor(novoProduto.getValor());
    
        //     Produto produtoAlterado = prodre.save(produtoAtual);
        //     return new ResponseEntity<Produto>(produtoAlterado, HttpStatus.OK);
        // } else {
        //     return new ResponseEntity<>(Map.of("mensagem", "Produto não encontrado"), HttpStatus.NOT_FOUND);
        // }}

    //delete
    public ResponseEntity<RespostaModelo> removerProduto(Integer codigo){
        prodre.deleteById(codigo);
        remo.setMensagem("Produto removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(remo, HttpStatus.OK);
    }

    public Optional<Produto> buscarProdutoPorId(Integer id_produto) {
        return prodre.findById(id_produto);
    }
}
