package com.PIN2.TotalConnect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.PIN2.TotalConnect.entity.Transportadora;
import com.PIN2.TotalConnect.service.TransportadoraService;

@Controller
public class TransportadoraController {

    private TransportadoraService transportadoraService;

    public TransportadoraController(TransportadoraService transportadoraService) {
        super();
        this.transportadoraService = transportadoraService;
    }

    @GetMapping("/transportadoras")
    public String listTransportadoras(Model model){
        model.addAttribute("transportadoras", transportadoraService.getAllTransportadoras());
        return "transportadoras";
    }

    @GetMapping("/transportadoras/new")
    public String createTransportadoraForm(Model model){
        Transportadora transportadora = new Transportadora();
        model.addAttribute("transportadora", transportadora);
        return "create_transportadora";
    }
    
    @PostMapping("/transportadoras")
    public String saveTransportadora(@ModelAttribute("transportadora") Transportadora transportadora){
        transportadoraService.saveTransportadora(transportadora);
        return "redirect:/transportadoras";
    }

    @GetMapping("/transportadoras/edit/{id}")
    public String editTransportadoraForm(@PathVariable Long id, Model model){
        model.addAttribute("transportadora", transportadoraService.getTransportadoraById(id));
        return "edit_transportadora";
    }

    @PostMapping("/transportadoras/{id}")
    public String updateTransportadora(@PathVariable Long id, @ModelAttribute("transportadora") Transportadora transportadora){

        Transportadora existingTransportadora = transportadoraService.getTransportadoraById(id);

        existingTransportadora.setNome(transportadora.getNome());
        existingTransportadora.setCidade(transportadora.getCidade());
        existingTransportadora.setPrecoKM(transportadora.getPrecoKM());

        transportadoraService.updateTransportadora(existingTransportadora);

        return "redirect:/transportadoras";
    }

    @GetMapping("/transportadoras/{id}")
    public String deleteTransportadora(@PathVariable Long id){
        transportadoraService.deleteTransportadora(id);
        return "redirect:/transportadoras";
    }
}
