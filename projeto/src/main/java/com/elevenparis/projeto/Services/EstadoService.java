package com.elevenparis.projeto.Services;

import com.elevenparis.projeto.Entity.Estado;
import com.elevenparis.projeto.Repository.EstadoRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository estadoRepository;

    public List<Estado> buscarTodos(){return estadoRepository.findAll();}


}
