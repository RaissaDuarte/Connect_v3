package com.PIN2.TotalConnect.service;

import java.util.List;

import com.PIN2.TotalConnect.entity.Transportadora;

public interface TransportadoraService {
    
   List<Transportadora> getAllTransportadoras();

    Transportadora saveTransportadora(Transportadora transportadora);

    Transportadora getTransportadoraById(Long id);

    Transportadora updateTransportadora(Transportadora transportadora);

    void deleteTransportadora(Long id);

}
