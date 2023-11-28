package com.PIN2.TotalConnect.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PIN2.TotalConnect.entity.QuadroAvisos;
import com.PIN2.TotalConnect.entity.QuadroPlantao;
import com.PIN2.TotalConnect.service.HomeService;

@RestController
@CrossOrigin("http://localhost:3000")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/quadroAvisos")
    public ResponseEntity<?> obterQuadroAvisos() {

        Optional<QuadroAvisos> quadroAvisos = homeService.obterQuadroAvisos();
        if (quadroAvisos.isPresent()) {
            return new ResponseEntity<>(quadroAvisos.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Quadro de Avisos não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/quadroPlantao")
    public ResponseEntity<?> obterQuadroPlantao() {

        Optional<QuadroPlantao> quadroPlantao = homeService.obterQuadroPlantao();
        if (quadroPlantao.isPresent()) {
            return new ResponseEntity<>(quadroPlantao.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Quadro de Plantão não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/atualizarQuadroAvisos")
    public ResponseEntity<?> atualizarQuadroAvisos(@RequestBody QuadroAvisos quadroAvisos) {
        return homeService.atualizarQuadroAvisos(quadroAvisos);
    }

    @PutMapping("/atualizarQuadroPlantao")
    public ResponseEntity<?> atualizarQuadroPlantao(@RequestBody QuadroPlantao quadroPlantao) {
        return homeService.atualizarQuadroPlantao(quadroPlantao);
    }

}
