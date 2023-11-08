package com.PIN2.TotalConnect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.PIN2.TotalConnect.entity.Fornecedor;
import com.PIN2.TotalConnect.service.FornecedorService;

@Controller
public class FornecedorController {

    private FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        super();
        this.fornecedorService = fornecedorService;
    }

    @GetMapping("/fornecedores")
    public String listFornecedores(Model model) {
        model.addAttribute("fornecedores", fornecedorService.getAllFornecedores());
        return "fornecedores";
    }

    @GetMapping("/fornecedores/new")
    public String createFornecedorForm(Model model) {
        Fornecedor fornecedor = new Fornecedor();
        model.addAttribute("fornecedor", fornecedor);
        return "create_fornecedor";
    }

    @PostMapping("/fornecedores")
    public String saveFornecedor(@ModelAttribute("fornecedor") Fornecedor Fornecedor) {
        fornecedorService.saveFornecedor(Fornecedor);
        return "redirect:/fornecedores";
    }

    @GetMapping("/fornecedores/edit/{id}")
    public String editFornecedorForm(@PathVariable Long id, Model model) {
        model.addAttribute("fornecedor", fornecedorService.getFornecedorById(id));
        return "edit_fornecedor";
    }

    @PostMapping("/fornecedores/{id}")
    public String updateFornecedor(@PathVariable Long id, @ModelAttribute("fornecedor") Fornecedor fornecedor,
            Model model) {

        Fornecedor existingFornecedor = fornecedorService.getFornecedorById(id);

        existingFornecedor.setNome(fornecedor.getNome());
        existingFornecedor.setCnpj(fornecedor.getCnpj());
        existingFornecedor.setEndereco(fornecedor.getEndereco());
        existingFornecedor.setCep(fornecedor.getCep());
        existingFornecedor.setTelefone(fornecedor.getTelefone());

        fornecedorService.updateFornecedor(existingFornecedor);

        return "redirect:/fornecedores";
    }

    @GetMapping("/fornecedores/{id}")
    public String deleteFornecedor(@PathVariable Long id) {
        fornecedorService.deleteFornecedor(id);
        return "redirect:/fornecedores";
    }

}
