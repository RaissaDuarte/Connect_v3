package com.PIN2.TotalConnect.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PIN2.TotalConnect.entity.Transportadora;
import com.PIN2.TotalConnect.repository.TransportadoraRepository;
import com.PIN2.TotalConnect.service.TransportadoraService;

@Service
public class TransportadoraServiceImpl implements TransportadoraService{

    private TransportadoraRepository transportadoraRepository;    

    public TransportadoraServiceImpl(TransportadoraRepository transportadoraRepository) {
        super();
        this.transportadoraRepository = transportadoraRepository;
    }

    @Override
    public List<Transportadora> getAllTransportadoras() {
        return transportadoraRepository.findAll();
    }

    @Override
    public Transportadora saveTransportadora(Transportadora transportadora){
        return transportadoraRepository.save(transportadora);
    }

    @Override
    public Transportadora getTransportadoraById(Long id) {
        return transportadoraRepository.findById(id).get();
    }

    @Override
    public Transportadora updateTransportadora(Transportadora transportadora) {
        return transportadoraRepository.save(transportadora);
    }

    @Override
    public void deleteTransportadora(Long id) {
        transportadoraRepository.deleteById(id);
    }
    
}
