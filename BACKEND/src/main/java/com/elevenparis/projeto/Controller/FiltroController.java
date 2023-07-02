package com.elevenparis.projeto.Controller;

import com.elevenparis.projeto.Entity.Filtro;
import com.elevenparis.projeto.Service.FiltroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/filtro")
public class FiltroController {

    @Autowired
    private FiltroService filtroService;

    @GetMapping("/{id}")
    public ResponseEntity<Filtro> getFiltro(@PathVariable Long id) {
        Filtro filtro = filtroService.getFiltro(id);
        if (filtro != null) {
            return ResponseEntity.ok(filtro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Filtro> createFiltro(@RequestBody Filtro filtro) {
        Filtro newFiltro = filtroService.createFiltro(filtro);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFiltro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filtro> updateFiltro(@PathVariable Long id, @RequestBody Filtro filtro) {
        Filtro updatedFiltro = filtroService.updateFiltro(id, filtro);
        if (updatedFiltro != null) {
            return ResponseEntity.ok(updatedFiltro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFiltro(@PathVariable Long id) {
        boolean deleted = filtroService.deleteFiltro(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
