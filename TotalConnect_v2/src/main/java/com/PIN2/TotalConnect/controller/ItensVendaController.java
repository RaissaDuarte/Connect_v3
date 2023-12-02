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
import com.PIN2.TotalConnect.service.ItemVendaService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ItensVendaController {    
    
    @Autowired
    private ItemVendaService itvendaService;

    @PostMapping("/caditvenda")
    public ResponseEntity<?> cadastrar(@RequestBody ItemVenda v){
        return itvendaService.cadastraritVenda(v);
    }

    @GetMapping("/itvendas")
    public Iterable<ItemVenda> listar(){
        return itvendaService.listarTodasitVendas();
    }

    @GetMapping("/itvenda/{id_venda}")
    public ResponseEntity<?> buscaritVendaPorId(@PathVariable("id_itemVenda") Integer id_itemVenda) {
    Optional<ItemVenda> itvenda = itvendaService.buscarVendaPorId(id_itemVenda);
    if (itvenda.isPresent()) {
        return new ResponseEntity<>(itvenda.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Item não encontrado", HttpStatus.NOT_FOUND);
    }
}
    
    @PutMapping("/alteraritvenda")
    public ResponseEntity<?> alterar(@RequestBody ItemVenda v){
        return itvendaService.alteraritVenda(v);
    }

    @DeleteMapping("/delitvenda/{id_itemVenda}")
    public ResponseEntity<RespostaModelo> removeritVenda(@PathVariable("id_itemVenda") Integer id_itemVenda){
        return itvendaService.removeritVenda(id_itemVenda);
    }

}

