package com.elevenparis.projeto.Services;

import com.elevenparis.projeto.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaById(Long id) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        return optionalCategoria.orElse(null);
    }

    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria updateCategoria(Long id, Categoria categoria) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        if (optionalCategoria.isPresent()) {
            Categoria categoriaExistente = optionalCategoria.get();
            categoriaExistente.setCamisa(categoria.getCamisa());
            categoriaExistente.setCamiseta(categoria.getCamiseta());
            categoriaExistente.setCalca(categoria.getCalca());
            categoriaExistente.setShorts(categoria.getShorts());
            categoriaExistente.setTenis(categoria.getTenis());
            categoriaExistente.setBlusa(categoria.getBlusa());
            return categoriaRepository.save(categoriaExistente);
        } else {
            return null;
        }
    }


    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
