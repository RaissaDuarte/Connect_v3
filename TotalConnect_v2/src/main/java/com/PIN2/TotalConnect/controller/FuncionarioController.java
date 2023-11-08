package com.PIN2.TotalConnect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.PIN2.TotalConnect.entity.Funcionario;
import com.PIN2.TotalConnect.service.FuncionarioService;

@Controller
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        super();
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/funcionarios")
    public String listFuncionarios(Model model) {
        model.addAttribute("funcionarios", funcionarioService.getAllFuncionarios());
        return "funcionarios";
    }

    @GetMapping("/funcionarios/new")
    public String createFuncionarioForm(Model model) {
        Funcionario funcionario = new Funcionario();
        model.addAttribute("funcionario", funcionario);
        return "create_funcionario";
    }

    @PostMapping("/funcionarios")
    public String saveFuncionario(@ModelAttribute("funcionario") Funcionario funcionario) {
        funcionarioService.saveFuncionario(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/funcionarios/edit/{id}")
    public String editFuncionarioForm(@PathVariable Long id, Model model) {
        model.addAttribute("funcionario", funcionarioService.getFuncionarioById(id));
        return "edit_funcionario";
    }

    @PostMapping("/funcionarios/{id}")
    public String updateFuncionario(@PathVariable Long id, @ModelAttribute("funcionario") Funcionario funcionario,
            Model model) {

        Funcionario existingFuncionario = funcionarioService.getFuncionarioById(id);

        existingFuncionario.setNome(funcionario.getNome());
        existingFuncionario.setCpf(funcionario.getCpf());
        existingFuncionario.setSenha(funcionario.getSenha());
        existingFuncionario.setEndereco(funcionario.getEndereco());
        existingFuncionario.setCep(funcionario.getCep());
        existingFuncionario.setTelefone(funcionario.getTelefone());

        funcionarioService.updateFuncionario(existingFuncionario);

        return "redirect:/funcionarios";
    }

    @GetMapping("/funcionarios/{id}")
    public String deleteFuncionario(@PathVariable Long id) {
        funcionarioService.deleteFuncionario(id);
        return "redirect:/funcionarios";
    }

}
