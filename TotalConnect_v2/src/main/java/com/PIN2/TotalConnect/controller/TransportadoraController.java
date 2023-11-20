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

import com.PIN2.TotalConnect.entity.RespostaModelo;
import com.PIN2.TotalConnect.entity.Transportadora;
import com.PIN2.TotalConnect.service.TransportadoraService;

@RestController
@CrossOrigin("http://localhost:3000")
public class TransportadoraController {
    
    @Autowired
    private TransportadoraService transpser;

    @PostMapping("/cadtransp")
    public ResponseEntity<?> cadastrar(@RequestBody Transportadora p){
        return transpser.cadastrarTransportadora(p);
    }

    @GetMapping("/transportadoras")
    public Iterable<Transportadora> listar(){
        return transpser.listarTodasTransportadoras();
    }
    
    @PutMapping("/alterartrans")
    public ResponseEntity<?> alterar(@RequestBody Transportadora p){
        return transpser.alterarTransportadora(p);
    }

    @DeleteMapping("/transportadoras/delete/{idTransportadora}")
    public ResponseEntity<RespostaModelo> removerTransportadora(@PathVariable Integer idTransportadora){
        return transpser.removerTransportadora(idTransportadora);
    }

}
