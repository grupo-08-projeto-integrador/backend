package com.elevenparis.projeto.Service;

import com.elevenparis.projeto.Entity.Filtro;
import com.elevenparis.projeto.Repository.FiltroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FiltroService {

    @Autowired
    private FiltroRepository filtroRepository;

    public Filtro getFiltro(Long id) {
        Optional<Filtro> optionalFiltro = filtroRepository.findById(id);
        return optionalFiltro.orElse(null);
    }

    public Filtro createFiltro(Filtro filtro) {
        return filtroRepository.save(filtro);
    }

    public Filtro updateFiltro(Long id, Filtro filtro) {
        Optional<Filtro> optionalFiltro = filtroRepository.findById(id);
        if (optionalFiltro.isPresent()) {
            Filtro existingFiltro = optionalFiltro.get();
            existingFiltro.setNome(filtro.getNome());
            existingFiltro.setTamanho(filtro.getTamanho());
            existingFiltro.setCor(filtro.getCor());
            existingFiltro.setTipo(filtro.getTipo());
            return filtroRepository.save(existingFiltro);
        } else {
            return null;
        }
    }

    public boolean deleteFiltro(Long id) {
        if (filtroRepository.existsById(id)) {
            filtroRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Filtro> getAllFiltros() {
        return filtroRepository.findAll();
    }
}
