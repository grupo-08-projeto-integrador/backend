package com.elevenparis.projeto.Repository;

import com.elevenparis.projeto.Entity.ItemVenda;
import com.elevenparis.projeto.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
