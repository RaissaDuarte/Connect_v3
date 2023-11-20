package com.PIN2.TotalConnect.service;

import com.PIN2.TotalConnect.entity.QuadroAvisos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    private final QuadroAvisosService quadroAvisosService;

    @Autowired
    public HomeService(QuadroAvisosService quadroAvisosService) {
        this.quadroAvisosService = quadroAvisosService;
    }

    public QuadroAvisos obterQuadroAvisos() {
        return quadroAvisosService.obterQuadroAvisos();
    }

    public QuadroAvisos atualizarQuadroAvisos(QuadroAvisos quadroAvisos) {
        return quadroAvisosService.atualizarQuadroAvisos(quadroAvisos);
    }

    public QuadroAvisos getQuadroAvisosById(Integer id) {
        return quadroAvisosService.getQuadroAvisosById(id);
    }
}
