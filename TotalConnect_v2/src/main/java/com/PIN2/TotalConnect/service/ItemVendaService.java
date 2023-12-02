package com.PIN2.TotalConnect.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.PIN2.TotalConnect.entity.ItemVenda;
import com.PIN2.TotalConnect.entity.Produto;
import com.PIN2.TotalConnect.entity.RespostaModelo;
import com.PIN2.TotalConnect.entity.Venda;
import com.PIN2.TotalConnect.repository.ItemVendaRepository;
import com.PIN2.TotalConnect.repository.VendaRepository;

@Service
public class ItemVendaService {

    
    @Autowired
    private ItemVendaRepository vendaitrepositorio;

    @Autowired
    private RespostaModelo respmodelo;

    //listar
    public Iterable<ItemVenda> listarTodasitVendas(){
        return vendaitrepositorio.findAll();
    }
    
    //cadastrar
    public ResponseEntity<?> cadastraritVenda(ItemVenda v){

            return new ResponseEntity<ItemVenda>(vendaitrepositorio.save(v), HttpStatus.CREATED);
    }

    //alterar
    public ResponseEntity<?> alteraritVenda(ItemVenda v){
            respmodelo.setMensagem("Item alterado com sucesso!");
            return new ResponseEntity<ItemVenda>(vendaitrepositorio.save(v), HttpStatus.OK);
    }

    
    //busca por id
    public Optional<ItemVenda> buscaritVendaPorId(Integer id_itemVenda) {
        return vendaitrepositorio.findById(id_itemVenda);
    }

    //exclui
    public ResponseEntity<RespostaModelo> removeritVenda(Integer codigo){
        vendaitrepositorio.deleteById(codigo);
        respmodelo.setMensagem("Produto removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(respmodelo, HttpStatus.OK);
    }

    

}

