package com.PIN2.TotalConnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.PIN2.TotalConnect.entity.Funcionario;
import com.PIN2.TotalConnect.entity.QuadroAvisos;
import com.PIN2.TotalConnect.service.QuadroAvisosService;

@Controller  // Use @Controller em vez de @RestController
@CrossOrigin("http://localhost:3000")
public class HomeController {

    @Autowired
    private QuadroAvisosService quadroAvisosService;

    @GetMapping("/home")
    public String starterHome(Model model) {
        QuadroAvisos quadroAvisos = quadroAvisosService.obterQuadroAvisos();
        model.addAttribute("quadroAvisos", quadroAvisos);
        return "home";
    }

    @GetMapping("/home/edit/quadroAvisos/{id}")
    public String editQuadroAvisos(@PathVariable Integer id, Model model) {
        model.addAttribute("quadroAvisos", quadroAvisosService.getQuadroAvisosById(id));
        return "edit_quadroAvisos";
    }

    @PostMapping("/home/quadroAvisos/{id}")
    public String updateQuadroAvisos(@PathVariable Integer id,
            @ModelAttribute("quadroAvisos") QuadroAvisos quadroAvisos,
            @ModelAttribute("funcionario") Funcionario funcionario) {

        QuadroAvisos existingQuadroAvisos = quadroAvisosService.getQuadroAvisosById(id);

        existingQuadroAvisos.setFuncionario(funcionario);
        existingQuadroAvisos.setMensagem(quadroAvisos.getMensagem());

        quadroAvisosService.atualizarQuadroAvisos(existingQuadroAvisos);

        return "redirect:/home";
    }
}
