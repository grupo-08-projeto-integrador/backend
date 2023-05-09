package com.elevenparis.projeto.Repository;

import com.elevenparis.projeto.Entity.Carrinho;
import com.elevenparis.projeto.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho,Long>{


}
