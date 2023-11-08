package com.PIN2.TotalConnect.service.serviceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.PIN2.TotalConnect.entity.QuadroAvisos;
import com.PIN2.TotalConnect.repository.QuadroAvisosRepository;
import com.PIN2.TotalConnect.service.QuadroAvisosService;

@Service
public class QuadroAvisosServiceImpl implements QuadroAvisosService{

    private QuadroAvisosRepository quadroAvisosRepository;    

    public QuadroAvisosServiceImpl(QuadroAvisosRepository quadroAvisosRepository) {
        super();
        this.quadroAvisosRepository = quadroAvisosRepository;
    }
    
    @Override
    public QuadroAvisos getQuadroAvisosById(Long id) {
        return quadroAvisosRepository.findById(id).get();
    }

    public QuadroAvisos obterQuadroAvisos() {
        Optional<QuadroAvisos> quadroAvisosOptional = quadroAvisosRepository.findById(1L); // Use 1L para representar o ID 1 como um Long
        if (quadroAvisosOptional.isPresent()) {
            QuadroAvisos quadroAvisos = quadroAvisosOptional.get();
            return quadroAvisos;
        } else {
            // Lida com o caso em que o ID 1 não existe na tabela
            return null;
        }
    }

    @Override
    public QuadroAvisos updateQuadroAvisos(QuadroAvisos quadroAvisos) {
        return quadroAvisosRepository.save(quadroAvisos);
    } 
    

}
