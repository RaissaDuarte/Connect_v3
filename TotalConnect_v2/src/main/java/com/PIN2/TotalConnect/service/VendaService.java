package com.PIN2.TotalConnect.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.PIN2.TotalConnect.entity.ItemVenda;
import com.PIN2.TotalConnect.entity.RespostaModelo;
import com.PIN2.TotalConnect.entity.Venda;
import com.PIN2.TotalConnect.repository.VendaRepository;

@Service
public class VendaService {
    
    @Autowired
    private VendaRepository vendarepositorio;

    @Autowired
    private RespostaModelo respmodelo;

    //listar
    public Iterable<Venda> listarTodasVendas(){
        return vendarepositorio.findAll();
    }
    
    //cadastrar
    public ResponseEntity<?> cadastrarVenda(Venda v){

        for (ItemVenda item : v.getItensVenda()) {
            item.setVenda(v);
        }
            respmodelo.setMensagem("Produto cadastrado com sucesso!");
            return new ResponseEntity<Venda>(vendarepositorio.save(v), HttpStatus.CREATED);
    }

    //alterar
    public ResponseEntity<?> alterarVenda(Venda v){
            respmodelo.setMensagem("Produto alterado com sucesso!");
            return new ResponseEntity<Venda>(vendarepositorio.save(v), HttpStatus.OK);
    }

    
    //busca por id
    public Optional<Venda> buscarVendaPorId(Integer id_venda) {
        return vendarepositorio.findById(id_venda);
    }

    //exclui
    public ResponseEntity<RespostaModelo> removerVenda(Integer codigo){
        vendarepositorio.deleteById(codigo);
        respmodelo.setMensagem("Produto removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(respmodelo, HttpStatus.OK);
    }

    

}
