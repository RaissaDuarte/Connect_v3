package com.PIN2.TotalConnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.PIN2.TotalConnect.entity.Transportadora;
import com.PIN2.TotalConnect.entity.RespostaModelo;
import com.PIN2.TotalConnect.repository.TransportadoraRepository;

@Service
public class TransportadoraService {

    @Autowired
    private TransportadoraRepository transportadoraRepository;

    @Autowired
    private RespostaModelo respostaModelo;

    // Listar todas as transportadoras
    public Iterable<Transportadora> listarTodasTransportadoras() {
        return transportadoraRepository.findAll();
    }

    // Cadastrar uma nova transportadora
    public ResponseEntity<?> cadastrarTransportadora(Transportadora transportadora) {
        if (transportadora.getNome().isEmpty()) {
            respostaModelo.setMensagem("Campo nome está vazio");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Transportadora>(transportadoraRepository.save(transportadora), HttpStatus.CREATED);
        }
    }

    // Alterar informações de uma transportadora
    public ResponseEntity<?> alterarTransportadora(Transportadora transportadora) {
        return new ResponseEntity<Transportadora>(transportadoraRepository.save(transportadora), HttpStatus.OK);
    }

    public Transportadora obterTransportadoraPorId(Integer id) {
        return transportadoraRepository.findById(id).orElse(null);
    }

    // Remover uma transportadora
    public ResponseEntity<RespostaModelo> removerTransportadora(Integer codigo) {
        transportadoraRepository.deleteById(codigo);
        respostaModelo.setMensagem("Transportadora removida com sucesso!");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }
}
