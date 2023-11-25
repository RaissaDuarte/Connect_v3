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

import com.PIN2.TotalConnect.entity.ItemVenda;
import com.PIN2.TotalConnect.entity.RespostaModelo;
import com.PIN2.TotalConnect.entity.Venda;
import com.PIN2.TotalConnect.service.VendaService;


@RestController
@CrossOrigin("http://localhost:3000")
public class VendaController {
    
    
    @Autowired
    private VendaService vendaService;

    @PostMapping("/cadvenda")
    public ResponseEntity<?> cadastrar(@RequestBody Venda v){
        return vendaService.cadastrarVenda(v);
    }

    @GetMapping("/vendas")
    public Iterable<Venda> listar(){
        return vendaService.listarTodasVendas();
    }

    @GetMapping("/venda/{id_venda}")
    public ResponseEntity<?> buscarVendaPorId(@PathVariable("id_venda") Integer id_venda) {
    Optional<Venda> venda = vendaService.buscarVendaPorId(id_venda);
    if (venda.isPresent()) {
        return new ResponseEntity<>(venda.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Venda não encontrada", HttpStatus.NOT_FOUND);
    }
}
    
    @PutMapping("/alterarvenda")
    public ResponseEntity<?> alterar(@RequestBody Venda v){
        return vendaService.alterarVenda(v);
    }

    @DeleteMapping("/delvenda/{id_venda}")
    public ResponseEntity<RespostaModelo> removerVenda(@PathVariable("id_venda") Integer id_venda){
        return vendaService.removerVenda(id_venda);
    }

}
