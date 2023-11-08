package com.PIN2.TotalConnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.PIN2.TotalConnect.entity.Funcionario;
import com.PIN2.TotalConnect.entity.QuadroAvisos;
import com.PIN2.TotalConnect.entity.QuadroPlantao;
import com.PIN2.TotalConnect.service.QuadroAvisosService;
import com.PIN2.TotalConnect.service.QuadroPlantaoService;

@Controller
public class HomeController {

    @Autowired
    private QuadroAvisosService quadroAvisosService;

    @Autowired
    private QuadroPlantaoService quadroPlantaoService;

    @Autowired
    public HomeController(QuadroAvisosService quadroAvisosService, QuadroPlantaoService quadroPlantaoService) {
        this.quadroAvisosService = quadroAvisosService;
        this.quadroPlantaoService = quadroPlantaoService;
    }

    @GetMapping("/home")
    public String starterHome(Model model) {
        QuadroAvisos quadroAvisos = quadroAvisosService.obterQuadroAvisos();
        QuadroPlantao quadroPlantao = quadroPlantaoService.obterQuadroPlantao();
        model.addAttribute("quadroAvisos", quadroAvisos);
        model.addAttribute("quadroPlantao", quadroPlantao);
        return "home";
    }

    @GetMapping("/home/edit/quadroAvisos/{id}")
    public String editQuadroAvisos(@PathVariable Long id, Model model) {
        model.addAttribute("quadroAvisos", quadroAvisosService.getQuadroAvisosById(id));
        return "edit_quadroAvisos";
    }

    @PostMapping("/home/quadroAvisos/{id}")
    public String updateQuadroAvisos(@PathVariable Long id, @ModelAttribute("quadroAvisos") QuadroAvisos quadroAvisos,
            @ModelAttribute("funcionario") Funcionario funcionario) {

        QuadroAvisos existingQuadroAvisos = quadroAvisosService.getQuadroAvisosById(id);

        existingQuadroAvisos.setFuncionario(funcionario);
        existingQuadroAvisos.setMensagem(quadroAvisos.getMensagem());

        quadroAvisosService.updateQuadroAvisos(existingQuadroAvisos);

        return "redirect:/home";
    }

    @GetMapping("/home/edit/quadroPlantao/{id}")
    public String editQuadroPlantao(@PathVariable Long id, Model model) {
        model.addAttribute("quadroPlantao", quadroPlantaoService.getQuadroPlantaoById(id));
        return "edit_quadroPlantao";
    }

    @PostMapping("/home/quadroPlantao/{id}")
    public String updateQuadroPlantao(@PathVariable Long id,
            @ModelAttribute("quadroPlantao") QuadroPlantao quadroPlantao,
            @ModelAttribute("funcionario") Funcionario funcionario) {

        QuadroPlantao existingQuadroPlantao = quadroPlantaoService.getQuadroPlantaoById(id);

        existingQuadroPlantao.setFuncionario(funcionario);
        existingQuadroPlantao.setMensagem(quadroPlantao.getMensagem());

        quadroPlantaoService.updateQuadroPlantao(existingQuadroPlantao);

        return "redirect:/home";
    }

}