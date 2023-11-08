package com.PIN2.TotalConnect.service.serviceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.PIN2.TotalConnect.entity.QuadroPlantao;
import com.PIN2.TotalConnect.repository.QuadroPlantaoRepository;
import com.PIN2.TotalConnect.service.QuadroPlantaoService;

@Service
public class QuadroPlantaoServiceImpl implements QuadroPlantaoService{

    private QuadroPlantaoRepository quadroPlantaoRepository;;    

    public QuadroPlantaoServiceImpl(QuadroPlantaoRepository quadroPlantaoRepository) {
        super();
        this.quadroPlantaoRepository = quadroPlantaoRepository;
    }
    
    @Override
    public QuadroPlantao getQuadroPlantaoById(Long id) {
        return quadroPlantaoRepository.findById(id).get();
    }

    @Override
    public QuadroPlantao updateQuadroPlantao(QuadroPlantao quadroPlantao) {
        return quadroPlantaoRepository.save(quadroPlantao);
    }

    @Override
    public QuadroPlantao obterQuadroPlantao() {
       Optional<QuadroPlantao> quadroPlantaoOptional = quadroPlantaoRepository.findById(1L); // Use 1L para representar o ID 1 como um Long
        if (quadroPlantaoOptional.isPresent()) {
            QuadroPlantao quadroPlantao = quadroPlantaoOptional.get();
            return quadroPlantao;
        } else {
            // Lida com o caso em que o ID 1 não existe na tabela
            return null;
        }
    } 
    

}
