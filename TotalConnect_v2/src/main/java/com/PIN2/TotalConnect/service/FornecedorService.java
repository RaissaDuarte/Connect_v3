package com.PIN2.TotalConnect.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PIN2.TotalConnect.entity.Fornecedor;

@Service
public interface FornecedorService {

    List<Fornecedor> getAllFornecedores();

    Fornecedor saveFornecedor(Fornecedor fornecedor);

    Fornecedor getFornecedorById(Long id);

    Fornecedor updateFornecedor(Fornecedor fornecedor);

    void deleteFornecedor(Long id);
    
}

