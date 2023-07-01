package com.elevenparis.projeto.Controller;

import com.elevenparis.projeto.Entity.ItemProduto;
import com.elevenparis.projeto.Services.ItemProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itemproduto")
public class ItemProdutoController {

    private final ItemProdutoService itemProdutoService;

    @Autowired
    public ItemProdutoController(ItemProdutoService itemProdutoService) {
        this.itemProdutoService = itemProdutoService;
    }

    @GetMapping
    public ResponseEntity<List<ItemProduto>> getAllItemProdutos() {
        List<ItemProduto> itemProdutos = itemProdutoService.getAllItemProdutos();
        return new ResponseEntity<>(itemProdutos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemProduto> getItemProdutoById(@PathVariable Long id) {
        ItemProduto itemProduto = itemProdutoService.getItemProdutoById(id);
        if (itemProduto != null) {
            return new ResponseEntity<>(itemProduto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ItemProduto> createItemProduto(@RequestBody ItemProduto itemProduto) {
        ItemProduto createdItemProduto = itemProdutoService.createItemProduto(itemProduto);
        return new ResponseEntity<>(createdItemProduto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemProduto> updateItemProduto(@PathVariable Long id, @RequestBody ItemProduto itemProduto) {
        ItemProduto updatedItemProduto = itemProdutoService.updateItemProduto(id, itemProduto);
        if (updatedItemProduto != null) {
            return new ResponseEntity<>(updatedItemProduto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemProduto(@PathVariable Long id) {
        itemProdutoService.deleteItemProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
