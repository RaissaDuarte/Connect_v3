package com.PIN2.TotalConnect.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PIN2.TotalConnect.entity.Funcionario;
import com.PIN2.TotalConnect.entity.RespostaModelo;
import com.PIN2.TotalConnect.service.FuncionarioService;

@RestController
@CrossOrigin("http://localhost:3000")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcSer;

    @PostMapping("/cadastroFuncionario")
    public ResponseEntity<?> cadastrar(@RequestBody Funcionario f) {
        return funcSer.cadastrarFuncionario(f);
    }

    @GetMapping("/funcionarios")
    public Iterable<Funcionario> listar() {
        return funcSer.listarTodosFuncionarios();
    }

    @GetMapping("/funcionarios/edit/{id}")
    public ResponseEntity<?> obterFuncionarioPorId(@PathVariable("id") Integer id) {
        Optional<Funcionario> funcionario = funcSer.obterFuncionarioPorId(id);
        if (funcionario.isPresent()) {
            return new ResponseEntity<>(funcionario.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Funcionário não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/alterarFuncionario")
    public ResponseEntity<?> alterar(@RequestBody Funcionario f) {
        return funcSer.alterarFuncionario(f);
    }

    @DeleteMapping("/funcionarios/delete/{idFuncionario}")
    public ResponseEntity<RespostaModelo> removerFuncionario(@PathVariable Integer idFuncionario) {
        return funcSer.removerFuncionario(idFuncionario);
    }
}
