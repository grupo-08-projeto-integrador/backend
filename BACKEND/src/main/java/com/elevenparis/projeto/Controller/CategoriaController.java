package com.elevenparis.projeto.Controller;

import com.elevenparis.projeto.Entity.Categoria;
import com.elevenparis.projeto.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    @GetMapping("/{id}")
    public Categoria getCategoriaById(@PathVariable Long id) {
        return categoriaService.getCategoriaById(id);
    }

    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return categoriaService.createCategoria(categoria);
    }

    @PutMapping("/{id}")
    public Categoria updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        return categoriaService.updateCategoria(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
    }
}
