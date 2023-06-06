package com.elevenparis.projeto.Repository;

import com.elevenparis.projeto.Entity.Estado;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    @Query
    List<Estado> findAllByAtivo(@Param("ativo")String ativo);

    @Query
    List<Estado> findAllByInativo(@Param("inativo")String inativo);

    @Query
    List<Estado> findAll();

    Optional<Estado> findByIdAndProdutosId(Long Estado, Long Produto);


}
