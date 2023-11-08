package com.PIN2.TotalConnect.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PIN2.TotalConnect.entity.Fornecedor;
import com.PIN2.TotalConnect.repository.FornecedorRepository;
import com.PIN2.TotalConnect.service.FornecedorService;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    private FornecedorRepository fornecedorRepository;
    

    public FornecedorServiceImpl(FornecedorRepository fornecedorRepository) {
        super();
        this.fornecedorRepository = fornecedorRepository;
    }

    @Override
    public List<Fornecedor> getAllFornecedores() {
        return fornecedorRepository.findAll();
    }

    @Override
    public Fornecedor saveFornecedor(Fornecedor Fornecedor) {
        return fornecedorRepository.save(Fornecedor);
    }

    @Override
    public Fornecedor getFornecedorById(Long id) {
        return fornecedorRepository.findById(id).get();
    }

    @Override
    public Fornecedor updateFornecedor(Fornecedor Fornecedor) {
        return fornecedorRepository.save(Fornecedor);
    }

    @Override
    public void deleteFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }
    
}
