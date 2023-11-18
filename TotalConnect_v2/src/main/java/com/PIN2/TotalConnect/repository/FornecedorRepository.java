package com.PIN2.TotalConnect.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.PIN2.TotalConnect.entity.Fornecedor;

@Repository
public interface FornecedorRepository extends CrudRepository<Fornecedor, Integer>{
    
}
