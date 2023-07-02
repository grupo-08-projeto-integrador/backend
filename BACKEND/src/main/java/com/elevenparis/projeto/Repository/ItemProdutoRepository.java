package com.elevenparis.projeto.Repository;

import com.elevenparis.projeto.Entity.ItemProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemProdutoRepository extends JpaRepository<ItemProduto, Long> {
}
