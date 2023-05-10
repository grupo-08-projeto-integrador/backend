package com.elevenparis.projeto.Controller;

import com.elevenparis.projeto.Entity.Descricao;
import com.elevenparis.projeto.Repository.DescricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/descricao")
public class DescricaoController {
    @Autowired
    DescricaoRepository descricaoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Descricao> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.descricaoRepository.findById(id).orElse(new Descricao()));
    }

    @GetMapping("/descricao/{material}")
    public ResponseEntity<?> findByMaterial(@PathVariable String material){
        return ResponseEntity.ok().body(this.descricaoRepository.findByMaterial(material));
    }

    @GetMapping("/descricao/{cor}")
    public ResponseEntity<?> findByCor(@PathVariable String cor){
        return ResponseEntity.ok().body(this.descricaoRepository.findByCor(cor));
    }

    @GetMapping("/descricao/{marca}")
    public ResponseEntity<?> findByMarca(@PathVariable String marca){
        return ResponseEntity.ok().body(this.descricaoRepository.findByMarca(marca));
    }

    @GetMapping("/descricao/{tamanhos}")
    public ResponseEntity<?> findByTamanhos(@PathVariable String tamanhos){
        return ResponseEntity.ok().body(this.descricaoRepository.findByTamanhos(tamanhos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, Descricao descricao){
        return ResponseEntity.ok().body(this.descricaoRepository.save(descricao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        this.descricaoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Descricao descricao){
        this.descricaoRepository.save(descricao);
        return ResponseEntity.ok().body("Criado com sucesso!");
    }


}
