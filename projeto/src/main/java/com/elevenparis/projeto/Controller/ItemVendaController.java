package com.elevenparis.projeto.Controller;

import com.elevenparis.projeto.Entity.ItemVenda;
import com.elevenparis.projeto.Repository.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/ItemVenda")
public class ItemVendaController {
    @Autowired
    private ItemVendaRepository itemVendaRepository;
    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id") final Long id){
        final ItemVenda itemVenda = this.itemVendaRepository.findById(id).orElse(null);
        return itemVenda == null
                ? ResponseEntity.badRequest().body("Nenhum valor encontrado.")
                : ResponseEntity.ok(itemVenda);
    }


    @GetMapping
    public ResponseEntity<?> findByIdRequest(@RequestParam("id") final Long id){
        final ItemVenda itemVenda = this.itemVendaRepository.findById(id).orElse(null);
        return itemVenda == null
                ? ResponseEntity.badRequest().body("Nenhum valor encontrado.")
                : ResponseEntity.ok(itemVenda);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> listaCompleta(){
        return ResponseEntity.ok(this.itemVendaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final ItemVenda itemVenda){
        try {
            this.itemVendaRepository.save(itemVenda);
            return ResponseEntity.ok("Registro Cadastrado com Sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError()
                    .body("Error: " + e.getCause().getCause().getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(
            @RequestParam("id") final Long id,
            @RequestBody final ItemVenda itemVenda
    ){
        try {
            final ItemVenda itemVendaBanco = this.itemVendaRepository.findById(id).orElse(null);

            if (itemVendaBanco == null || !itemVendaBanco.getId().equals(itemVenda.getId())){
                throw new RuntimeException("Não foi possivel identificar o registro informado.");
            }

            this.itemVendaRepository.save(itemVenda);
            return ResponseEntity.ok("Registro atualizado com Sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(
            @RequestParam("id") final Long id
    ){
        final ItemVenda itemVendaBanco = this.itemVendaRepository.findById(id).orElse(null);

        this.itemVendaRepository.delete(itemVendaBanco);
        return ResponseEntity.ok("Registro Excluido com Sucesso");
    }
}
