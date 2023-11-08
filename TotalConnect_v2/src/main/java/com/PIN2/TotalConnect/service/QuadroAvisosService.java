package com.PIN2.TotalConnect.service;

import com.PIN2.TotalConnect.entity.QuadroAvisos;

public interface QuadroAvisosService {
    
    QuadroAvisos obterQuadroAvisos(); 

    QuadroAvisos updateQuadroAvisos(QuadroAvisos quadroAvisos);
    
    QuadroAvisos getQuadroAvisosById(Long id);

}
