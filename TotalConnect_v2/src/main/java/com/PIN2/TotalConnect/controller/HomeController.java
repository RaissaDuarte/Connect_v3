package com.PIN2.TotalConnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.PIN2.TotalConnect.entity.Funcionario;
import com.PIN2.TotalConnect.entity.QuadroAvisos;
import com.PIN2.TotalConnect.entity.QuadroPlantao;
import com.PIN2.TotalConnect.service.QuadroAvisosService;
import com.PIN2.TotalConnect.service.QuadroPlantaoService;

@RestController
@CrossOrigin("http://localhost:3000")
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
    public ResponseEntity<Model> starterHome(Model model) {
        QuadroAvisos quadroAvisos = quadroAvisosService.obterQuadroAvisos();
        QuadroPlantao quadroPlantao = quadroPlantaoService.obterQuadroPlantao();
        model.addAttribute("quadroAvisos", quadroAvisos);
        model.addAttribute("quadroPlantao", quadroPlantao);
        return ResponseEntity.ok(model);
    }

    @GetMapping("/home/edit/quadroAvisos/{id}")
    public ResponseEntity<Model> editQuadroAvisos(@PathVariable Long id, Model model) {
        model.addAttribute("quadroAvisos", quadroAvisosService.getQuadroAvisosById(id));
        return ResponseEntity.ok(model);
    }

    @PostMapping("/home/quadroAvisos/{id}")
    public ResponseEntity<?> updateQuadroAvisos(@PathVariable Long id, @RequestBody QuadroAvisos quadroAvisos,
                                                @RequestBody Funcionario funcionario) {

        QuadroAvisos existingQuadroAvisos = quadroAvisosService.getQuadroAvisosById(id);

        existingQuadroAvisos.setFuncionario(funcionario);
        existingQuadroAvisos.setMensagem(quadroAvisos.getMensagem());

        quadroAvisosService.updateQuadroAvisos(existingQuadroAvisos);

        return ResponseEntity.ok("redirect:/home");
    }

    @GetMapping("/home/edit/quadroPlantao/{id}")
    public ResponseEntity<Model> editQuadroPlantao(@PathVariable Long id, Model model) {
        model.addAttribute("quadroPlantao", quadroPlantaoService.getQuadroPlantaoById(id));
        return ResponseEntity.ok(model);
    }

    @PostMapping("/home/quadroPlantao/{id}")
    public ResponseEntity<?> updateQuadroPlantao(@PathVariable Long id,
                                                 @RequestBody QuadroPlantao quadroPlantao,
                                                 @RequestBody Funcionario funcionario) {

        QuadroPlantao existingQuadroPlantao = quadroPlantaoService.getQuadroPlantaoById(id);

        existingQuadroPlantao.setFuncionario(funcionario);
        existingQuadroPlantao.setMensagem(quadroPlantao.getMensagem());

        quadroPlantaoService.updateQuadroPlantao(existingQuadroPlantao);

        return ResponseEntity.ok("redirect:/home");
    }
}
