package com.elevenparis.projeto.Services;

import com.elevenparis.projeto.Entity.ItemProduto;
import com.elevenparis.projeto.Repository.ItemProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemProdutoService {

    private final ItemProdutoRepository itemProdutoRepository;

    @Autowired
    public ItemProdutoService(ItemProdutoRepository itemProdutoRepository) {
        this.itemProdutoRepository = itemProdutoRepository;
    }

    public List<ItemProduto> getAllItemProdutos() {
        return itemProdutoRepository.findAll();
    }

    public ItemProduto getItemProdutoById(Long id) {
        return itemProdutoRepository.findById(id).orElse(null);
    }

    public ItemProduto createItemProduto(ItemProduto itemProduto) {
        return itemProdutoRepository.save(itemProduto);
    }

    public ItemProduto updateItemProduto(Long id, ItemProduto itemProduto) {
        ItemProduto existingItemProduto = itemProdutoRepository.findById(id).orElse(null);
        if (existingItemProduto != null) {
            existingItemProduto.setCor(itemProduto.getCor());
            existingItemProduto.setTamanho(itemProduto.getTamanho());
            existingItemProduto.setQuantidade(itemProduto.getQuantidade());
            return itemProdutoRepository.save(existingItemProduto);
        }
        return null;
    }

    public void deleteItemProduto(Long id) {
        itemProdutoRepository.deleteById(id);
    }
}
