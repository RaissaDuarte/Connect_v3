package com.PIN2.TotalConnect.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.PIN2.TotalConnect.entity.Funcionario;
import com.PIN2.TotalConnect.entity.RespostaModelo;
import com.PIN2.TotalConnect.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private RespostaModelo remo;

    public Optional<Funcionario> login(String cpf, String senha) {
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findByCpf(cpf);

        if (funcionarioOptional.isPresent() && funcionarioOptional.get().getSenha().equals(senha)) {
            return funcionarioOptional;
        }

        return Optional.empty();
    }

    public boolean verificarCpfExistente(String cpf) {
        return funcionarioRepository.existsByCpf(cpf);
    }

    public Iterable<Funcionario> listarTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public ResponseEntity<?> cadastrarFuncionario(Funcionario f) {
        if (verificarCpfExistente(f.getCpf())) {
            remo.setMensagem("CPF já cadastrado. Insira um CPF válido.");
            return new ResponseEntity<RespostaModelo>(remo, HttpStatus.BAD_REQUEST);
        } else if (f.getNome().equals("")) {
            remo.setMensagem("Campo nome está vazio");
            return new ResponseEntity<RespostaModelo>(remo, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Funcionario>(funcionarioRepository.save(f), HttpStatus.CREATED);
        }
    }

    public Optional<Funcionario> obterFuncionarioPorId(Integer id) {
        return funcionarioRepository.findById(id);
    }

    public ResponseEntity<?> alterarFuncionario(Funcionario f) {
        if (f.getNome().equals("")) {
            remo.setMensagem("Campo nome está vazio");
            return new ResponseEntity<RespostaModelo>(remo, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Funcionario>(funcionarioRepository.save(f), HttpStatus.OK);
        }
    }

    // Remover um funcionário
    public ResponseEntity<RespostaModelo> removerFuncionario(Integer id) {
        funcionarioRepository.deleteById(id);
        remo.setMensagem("Funcionário removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(remo, HttpStatus.OK);
    }
}
