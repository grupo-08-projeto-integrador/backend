package com.elevenparis.projeto.Services;

import com.elevenparis.projeto.Entity.Descricao;
import com.elevenparis.projeto.Repository.DescricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DescricaoService {

    @Autowired
    DescricaoRepository descricaoRepository;

    public Descricao findById(Long id) {
        return this.descricaoRepository.findById(id).orElse(new Descricao());
    }

    public List<Descricao> findByMaterial(String material) {
        return this.descricaoRepository.findByMaterial(material);
    }

    public List<Descricao> findByCor(String cor) {
        return this.descricaoRepository.findByCor(cor);
    }

    public List<Descricao> findByMarca(String marca) {
        return this.descricaoRepository.findByMarca(marca);
    }

    public List<Descricao> findByTamanhos(String tamanhos) {
        return this.descricaoRepository.findByTamanhos(tamanhos);
    }

    public Descricao update(Long id, Descricao descricao) {
        Optional<Descricao> optionalDescricao = this.descricaoRepository.findById(id);
        if (optionalDescricao.isPresent()) {
            Descricao desc = optionalDescricao.get();
            desc.setMaterial(descricao.getMaterial());
            desc.setCor(descricao.getCor());
            desc.setMarca(descricao.getMarca());
            desc.setTamanhos(descricao.getTamanhos());
            return this.descricaoRepository.save(desc);
        } else {
            return new Descricao();
        }
    }

    public void delete(Long id) {
        this.descricaoRepository.deleteById(id);
    }

    public Descricao create(Descricao descricao) {
        return this.descricaoRepository.save(descricao);
    }

    public List<Descricao> findAll() {
        return this.descricaoRepository.findAll();
    }
}

