package com.PIN2.TotalConnect.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.PIN2.TotalConnect.entity.ItemVenda;
import com.PIN2.TotalConnect.entity.RespostaModelo;
import com.PIN2.TotalConnect.entity.Venda;
import com.PIN2.TotalConnect.repository.VendaRepository;

public class ItensVendaService {
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private RespostaModelo respostaModelo;

    public ResponseEntity<?> adicionarItemVenda(Integer id_venda, ItemVenda item) {
        Optional<Venda> optionalVenda = vendaRepository.findById(id_venda);
        if (optionalVenda.isPresent()) {
            Venda venda = optionalVenda.get();
            item.setVenda(venda);

            venda.getItensVenda().add(item);
            vendaRepository.save(venda);

            respostaModelo.setMensagem("Item adicionado à venda com sucesso!");
            return new ResponseEntity<>(respostaModelo, HttpStatus.OK);
        } else {
            respostaModelo.setMensagem("Venda não encontrada");
            return new ResponseEntity<>(respostaModelo, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> atualizarItemVenda(Integer id_venda, ItemVenda item){
        Optional<Venda> optionalVenda = vendaRepository.findById(id_venda);
        if (optionalVenda.isPresent()) {
            Venda venda = optionalVenda.get();
            vendaRepository.save(venda); 
    
            respostaModelo.setMensagem("Item da venda atualizado com sucesso!");
            return new ResponseEntity<>(respostaModelo, HttpStatus.OK);
        } else {
            respostaModelo.setMensagem("Venda não encontrada");
            return new ResponseEntity<>(respostaModelo, HttpStatus.NOT_FOUND);
        }
    }
    
    public ResponseEntity<?> removerItemVenda(Integer id_venda, Integer idItem){
        Optional<Venda> optionalVenda = vendaRepository.findById(id_venda);
        if (optionalVenda.isPresent()) {
            Venda venda = optionalVenda.get();

            ItemVenda itemParaRemover = null;
            for (ItemVenda item : venda.getItensVenda()) {
                if (item.getId().equals(idItem)) {
                    itemParaRemover = item;
                    break;
                }
            }            

            if (itemParaRemover != null) {
                venda.getItensVenda().remove(itemParaRemover); 
                vendaRepository.save(venda);

                respostaModelo.setMensagem("Item removido da venda com sucesso!");
                return new ResponseEntity<>(respostaModelo, HttpStatus.OK);
            } else {
                respostaModelo.setMensagem("Item não encontrado na venda");
                return new ResponseEntity<>(respostaModelo, HttpStatus.NOT_FOUND);
            }
        } else {
            respostaModelo.setMensagem("Venda não encontrada");
            return new ResponseEntity<>(respostaModelo, HttpStatus.NOT_FOUND);
        }
    }
}
