package com.PIN2.TotalConnect.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PIN2.TotalConnect.entity.Funcionario;
import com.PIN2.TotalConnect.repository.FuncionarioRepository;
import com.PIN2.TotalConnect.service.FuncionarioService;


@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private FuncionarioRepository funcionarioRepository;
    

    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
        super();
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario saveFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario getFuncionarioById(Long id) {
        return funcionarioRepository.findById(id).get();
    }

    @Override
    public Funcionario updateFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public void deleteFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }
    
}
