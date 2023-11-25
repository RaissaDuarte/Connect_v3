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
    private FuncionarioRepository funcre;

    @Autowired
    private RespostaModelo remo;

    public Iterable<Funcionario> listarTodosFuncionarios() {
        return funcre.findAll();
    }

    public ResponseEntity<?> cadastrarFuncionario(Funcionario f) {
        if (f.getNome().equals("")) {
            remo.setMensagem("Campo nome está vazio");
            return new ResponseEntity<RespostaModelo>(remo, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Funcionario>(funcre.save(f), HttpStatus.CREATED);
        }
    }

    public Optional<Funcionario> obterFuncionarioPorId(Integer id) {
        return funcre.findById(id);
    }

    public ResponseEntity<?> alterarFuncionario(Funcionario f) {
        if(f.getNome().equals("")){
            remo.setMensagem("Campo nome está vazio");
            return new ResponseEntity<RespostaModelo>(remo, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<Funcionario>(funcre.save(f), HttpStatus.OK);
        }
    }

    // Remover um funcionário
    public ResponseEntity<RespostaModelo> removerFuncionario(Integer id) {
        funcre.deleteById(id);
        remo.setMensagem("Funcionário removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(remo, HttpStatus.OK);
    }
}
