package com.PIN2.TotalConnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.PIN2.TotalConnect.entity.Fornecedor;
import com.PIN2.TotalConnect.entity.Funcionario;
import com.PIN2.TotalConnect.entity.RespostaModelo;
import com.PIN2.TotalConnect.repository.FornecedorRepository;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private RespostaModelo remo;

    public Iterable<Fornecedor> listarTodosFornecedores() {
        return fornecedorRepository.findAll();
    }

    public ResponseEntity<?> cadastrarFornecedor(Fornecedor fornecedor) {
        if (fornecedor.getNome().equals("")) {
            remo.setMensagem("Campo nome está vazio");
            return new ResponseEntity<RespostaModelo>(remo, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Fornecedor>(fornecedorRepository.save(fornecedor), HttpStatus.CREATED);
        }
    }

     public Fornecedor obterFornecedorPorId(Integer id) {
        return fornecedorRepository.findById(id).orElse(null);
    }

    public ResponseEntity<?> alterarFornecedor(Fornecedor fornecedor) {
        return new ResponseEntity<Fornecedor>(fornecedorRepository.save(fornecedor), HttpStatus.OK);
    }

    public ResponseEntity<RespostaModelo> removerFornecedor(Integer id) {
        fornecedorRepository.deleteById(id);
        remo.setMensagem("Fornecedor removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(remo, HttpStatus.OK);
    }
}
