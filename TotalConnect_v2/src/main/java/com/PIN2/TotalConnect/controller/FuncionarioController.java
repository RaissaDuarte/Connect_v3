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
import com.PIN2.TotalConnect.entity.LoginRequest;
import com.PIN2.TotalConnect.entity.RespostaModelo;
import com.PIN2.TotalConnect.service.FuncionarioService;

@RestController
@CrossOrigin("http://localhost:3000")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;
@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            String cpf = loginRequest.getCpf();
            String senha = loginRequest.getSenha();

            Optional<Funcionario> funcionarioOptional = funcionarioService.login(cpf, senha);

            if (funcionarioOptional.isPresent()) {
                // Credenciais válidas
                // Aqui você pode gerar um token JWT ou retornar outras informações necessárias
                Funcionario funcionario = funcionarioOptional.get();
                return ResponseEntity.ok(funcionario); // Retorna o Funcionario como JSON
            } else {
                // Credenciais inválidas
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } catch (Exception e) {
            // Trata qualquer exceção inesperada
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/cadastroFuncionario")
public ResponseEntity<?> cadastrar(@RequestBody Funcionario f) {
    if (funcionarioService.verificarCpfExistente(f.getCpf())) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CPF já cadastrado. Insira um CPF válido.");
    }

    return funcionarioService.cadastrarFuncionario(f);
}

    @GetMapping("/funcionarios")
    public Iterable<Funcionario> listar() {
        return funcionarioService.listarTodosFuncionarios();
    }

    @GetMapping("/funcionarios/edit/{id}")
    public ResponseEntity<?> obterFuncionarioPorId(@PathVariable("id") Integer id) {
        Optional<Funcionario> funcionario = funcionarioService.obterFuncionarioPorId(id);
        if (funcionario.isPresent()) {
            return new ResponseEntity<>(funcionario.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Funcionário não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/alterarFuncionario")
    public ResponseEntity<?> alterar(@RequestBody Funcionario f) {
        return funcionarioService.alterarFuncionario(f);
    }

    @DeleteMapping("/funcionarios/delete/{idFuncionario}")
    public ResponseEntity<RespostaModelo> removerFuncionario(@PathVariable Integer idFuncionario) {
        return funcionarioService.removerFuncionario(idFuncionario);
    }
}
