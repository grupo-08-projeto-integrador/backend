package com.elevenparis.projeto.Controller;

import com.elevenparis.projeto.Entity.ItemProduto;
import com.elevenparis.projeto.Repository.ItemProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itemproduto")
public class ItemProdutoController {

    @Autowired
    ItemProdutoRepository itemProdutoRepository;

    @GetMapping
    public ResponseEntity<List<ItemProduto>> getAllItemProdutos() {
        List<ItemProduto> itemProdutos = itemProdutoRepository.findAll();
        return new ResponseEntity<>(itemProdutos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemProduto> getItemProdutoById(@PathVariable Long id) {
        ItemProduto itemProduto = itemProdutoRepository.findById(id).orElse(null);
        if (itemProduto != null) {
            return new ResponseEntity<>(itemProduto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ItemProduto> createItemProduto(@RequestBody ItemProduto itemProduto) {
        ItemProduto createdItemProduto = itemProdutoRepository.save(itemProduto);
        return new ResponseEntity<>(createdItemProduto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemProduto> updateItemProduto(@PathVariable Long id, @RequestBody ItemProduto itemProduto) {
        ItemProduto existingItemProduto = itemProdutoRepository.findById(id).orElse(null);
        if (existingItemProduto != null) {
            existingItemProduto.setCor(itemProduto.getCor());
            existingItemProduto.setTamanho(itemProduto.getTamanho());
            existingItemProduto.setQuantidade(itemProduto.getQuantidade());
            ItemProduto updatedItemProduto = itemProdutoRepository.save(existingItemProduto);
            return new ResponseEntity<>(updatedItemProduto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemProduto(@PathVariable Long id) {
        ItemProduto itemProduto = itemProdutoRepository.findById(id).orElse(null);
        if (itemProduto != null) {
            itemProdutoRepository.delete(itemProduto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
