package com.PIN2.TotalConnect.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.PIN2.TotalConnect.entity.QuadroAvisos;
import com.PIN2.TotalConnect.entity.QuadroPlantao;
import com.PIN2.TotalConnect.entity.RespostaModelo;
import com.PIN2.TotalConnect.repository.QuadroAvisosRepository;
import com.PIN2.TotalConnect.repository.QuadroPlantaoRepository;

@Service
public class HomeService {

    @Autowired
    private QuadroAvisosRepository quadroAvisosRepository;

    @Autowired
    private QuadroPlantaoRepository quadroPlantaoRepository;

    @Autowired
    private RespostaModelo remo;

    public Optional<QuadroAvisos> obterQuadroAvisos() {
        return quadroAvisosRepository.findById(1);
    }

    public ResponseEntity<?> atualizarQuadroAvisos(QuadroAvisos quadroAvisos) {
        if (quadroAvisos.getFuncionario().getNome().equals("")) {
            remo.setMensagem("Campo nome está vazio");
            return new ResponseEntity<RespostaModelo>(remo, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<QuadroAvisos>(quadroAvisosRepository.save(quadroAvisos), HttpStatus.OK);
        }
    }

    public Optional<QuadroPlantao> obterQuadroPlantao() {
        return quadroPlantaoRepository.findById(1);
    }

    public ResponseEntity<?> atualizarQuadroPlantao(QuadroPlantao quadroPlantao) {
        try {
            // Adicione logs para depurar
            System.out.println("Recebido quadroPlantao: " + quadroPlantao);
    
            if (quadroPlantao.getFuncionario().getNome().equals("")) {
                remo.setMensagem("Campo nome está vazio");
                return new ResponseEntity<RespostaModelo>(remo, HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<QuadroPlantao>(quadroPlantaoRepository.save(quadroPlantao), HttpStatus.OK);
            }
        } catch (Exception e) {
            // Log da exceção
            e.printStackTrace();
            return new ResponseEntity<>("Erro interno ao processar a requisição", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
