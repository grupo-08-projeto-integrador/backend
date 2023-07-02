package com.elevenparis.projeto.Repository;

import com.elevenparis.projeto.Entity.ItemVenda;
import com.elevenparis.projeto.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query("from Produto where estado = true")
    public List<Produto> findAtivo();
}
