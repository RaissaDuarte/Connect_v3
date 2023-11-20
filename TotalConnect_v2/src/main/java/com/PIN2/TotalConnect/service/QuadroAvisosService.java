package com.PIN2.TotalConnect.service;

import com.PIN2.TotalConnect.entity.QuadroAvisos;
import com.PIN2.TotalConnect.repository.QuadroAvisosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuadroAvisosService {

    private final QuadroAvisosRepository quadroAvisosRepository;

    @Autowired
    public QuadroAvisosService(QuadroAvisosRepository quadroAvisosRepository) {
        this.quadroAvisosRepository = quadroAvisosRepository;
    }

    public QuadroAvisos obterQuadroAvisos() {
        return quadroAvisosRepository.findById(1).orElse(null);
    }

    public QuadroAvisos atualizarQuadroAvisos(QuadroAvisos quadroAvisos) {
        quadroAvisos.setId(1);
        return quadroAvisosRepository.save(quadroAvisos);
    }

    public QuadroAvisos getQuadroAvisosById(Integer id) {
        return quadroAvisosRepository.findById(id).orElse(null);
    }
}
