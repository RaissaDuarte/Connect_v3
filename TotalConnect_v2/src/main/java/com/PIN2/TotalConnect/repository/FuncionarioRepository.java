package com.PIN2.TotalConnect.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.PIN2.TotalConnect.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer>{
    Optional<Funcionario> findByCpf(String cpf);
}
