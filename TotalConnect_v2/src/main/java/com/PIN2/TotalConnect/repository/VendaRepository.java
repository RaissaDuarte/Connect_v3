package com.PIN2.TotalConnect.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


import com.PIN2.TotalConnect.entity.Venda;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Integer>{
    
}
