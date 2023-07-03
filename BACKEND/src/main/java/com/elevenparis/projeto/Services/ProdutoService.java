package com.elevenparis.projeto.Services;

import com.elevenparis.projeto.Entity.Produto;
import com.elevenparis.projeto.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(rollbackFor = Exception.class)
    public void cadastrar(final Produto produto) {

        Assert.isTrue(produto.getNome() != null, "nome nao informado");
        Assert.isTrue(produto.getPreco() != null, "preco nao informado");

        this.produtoRepository.save(produto);

    }

    @Transactional
    public void editar(final Long id, final Produto produto) {

        final Produto produtoBanco = this.produtoRepository.findById(id).orElse(null);

        Assert.isTrue(produto.getNome() != null, "nome nao foi colocado");
        Assert.isTrue(produto.getPreco() != null, "preco nao foi colocado");


        Assert.isTrue(produtoBanco != null || !produtoBanco.getId().equals(produto.getId()), "nao deu pra indentificar");

        this.produtoRepository.save(produto);
    }


    @Transactional
    public void deleta(final Produto produto) {

        final Produto produtoBanco = this.produtoRepository.findById(produto.getId()).orElse(null);

        this.produtoRepository.delete(produtoBanco);

    }
}