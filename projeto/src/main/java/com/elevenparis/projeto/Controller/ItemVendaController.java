package com.elevenparis.projeto.Controller;

import com.elevenparis.projeto.Entity.ItemVenda;
import com.elevenparis.projeto.Services.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itensvenda")
public class ItemVendaController {

    private final ItemVendaService itemVendaService;

    @Autowired
    public ItemVendaController(ItemVendaService itemVendaService) {
        this.itemVendaService = itemVendaService;
    }

    @GetMapping
    public List<ItemVenda> getAllItensVenda() {
        return itemVendaService.getAllItensVenda();
    }

    @GetMapping("/{id}")
    public ItemVenda getItemVendaById(@PathVariable Long id) {
        return itemVendaService.getItemVendaById(id);
    }

    @PostMapping
    public ItemVenda createItemVenda(@RequestBody ItemVenda itemVenda) {
        return itemVendaService.createItemVenda(itemVenda);
    }

    @PutMapping("/{id}")
    public ItemVenda updateItemVenda(@PathVariable Long id, @RequestBody ItemVenda itemVenda) {
        return itemVendaService.updateItemVenda(id, itemVenda);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItemVenda(@PathVariable Long id) {
        itemVendaService.deleteItemVenda(id);
        return ResponseEntity.ok().body("Deletado Com sucesso");
    }
}
