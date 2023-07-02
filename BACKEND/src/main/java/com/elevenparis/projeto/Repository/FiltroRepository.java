package com.elevenparis.projeto.Repository;

import com.elevenparis.projeto.Entity.Filtro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FiltroRepository extends JpaRepository<Filtro, Long> {
    List<Filtro> findByNome(String nome);
}
