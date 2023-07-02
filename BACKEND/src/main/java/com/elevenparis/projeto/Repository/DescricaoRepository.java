package com.elevenparis.projeto.Repository;

import com.elevenparis.projeto.Entity.Descricao;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DescricaoRepository extends JpaRepository<Descricao, Long> {
    @Query(value = "from Descricao where material = :material")
    List<Descricao> findByMaterial(@Param("material")String material);

    @Query(value = "from Descricao where cor = :cor")
    List<Descricao> findByCor(@Param("cor")String cor);

    @Query(value = "from Descricao where marca = :marca")
    List<Descricao> findByMarca(@Param("marca")String marca);

    @Query(value = "from Descricao where tamanhos = :tamanhos")
    List<Descricao> findByTamanhos(@Param("tamanhos")String tamanhos);


}
