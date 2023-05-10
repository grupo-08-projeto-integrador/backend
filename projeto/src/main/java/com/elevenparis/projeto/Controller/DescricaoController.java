package com.elevenparis.projeto.Controller;

import com.elevenparis.projeto.Entity.Descricao;
import com.elevenparis.projeto.Repository.DescricaoRepository;
import com.elevenparis.projeto.Services.DescricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/descricao")
public class DescricaoController {

    @Autowired
    DescricaoService descricaoService;
    @Autowired
    DescricaoRepository descricaoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Descricao> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.descricaoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Descricao> descricoes = descricaoService.findAll();
        return ResponseEntity.ok().body(descricoes);
    }

    @GetMapping("/material/{material}")
    public ResponseEntity<?> findByMaterial(@PathVariable String material){
        return ResponseEntity.ok().body(this.descricaoService.findByMaterial(material));
    }

    @GetMapping("/cor/{cor}")
    public ResponseEntity<?> findByCor(@PathVariable String cor){
        return ResponseEntity.ok().body(this.descricaoService.findByCor(cor));
    }

    @GetMapping("/marca/{marca}")
    public ResponseEntity<?> findByMarca(@PathVariable String marca){
        return ResponseEntity.ok().body(this.descricaoService.findByMarca(marca));
    }

    @GetMapping("/tamanhos/{tamanhos}")
    public ResponseEntity<?> findByTamanhos(@PathVariable String tamanhos){
        return ResponseEntity.ok().body(this.descricaoService.findByTamanhos(tamanhos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Descricao> update(@PathVariable Long id, @RequestBody Descricao descricao){
        Descricao updatedDescricao = this.descricaoService.update(id, descricao);
        return ResponseEntity.ok().body(updatedDescricao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        this.descricaoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Descricao> create(@RequestBody Descricao descricao){
        Descricao createdDescricao = this.descricaoService.create(descricao);
        return ResponseEntity.ok().body(createdDescricao);
    }

}
