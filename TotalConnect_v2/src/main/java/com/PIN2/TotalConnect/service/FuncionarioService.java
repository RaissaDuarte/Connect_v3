package com.PIN2.TotalConnect.service;

import java.util.List;

import com.PIN2.TotalConnect.entity.Funcionario;

public interface FuncionarioService {

    List<Funcionario> getAllFuncionarios();

    Funcionario saveFuncionario(Funcionario funcionario);

    Funcionario getFuncionarioById(Long id);

    Funcionario updateFuncionario(Funcionario funcionario);

    void deleteFuncionario(Long id);
    
}
