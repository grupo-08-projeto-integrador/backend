package com.elevenparis.projeto.Services;

import com.elevenparis.projeto.Entity.ItemVenda;
import com.elevenparis.projeto.Repository.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemVendaService {

    private final ItemVendaRepository itemVendaRepository;

    @Autowired
    public ItemVendaService(ItemVendaRepository itemVendaRepository) {
        this.itemVendaRepository = itemVendaRepository;
    }

    public List<ItemVenda> getAllItensVenda() {
        return itemVendaRepository.findAll();
    }

    public ItemVenda getItemVendaById(Long id) {
        Optional<ItemVenda> optionalItemVenda = itemVendaRepository.findById(id);
        return optionalItemVenda.orElse(null);
    }

    public ItemVenda createItemVenda(ItemVenda itemVenda) {
        return itemVendaRepository.save(itemVenda);
    }

    public ItemVenda updateItemVenda(Long id, ItemVenda itemVenda) {
        Optional<ItemVenda> optionalItemVenda = itemVendaRepository.findById(id);
        if (optionalItemVenda.isPresent()) {
            ItemVenda itemVendaExistente = optionalItemVenda.get();
            itemVendaExistente.setQuantidade(itemVenda.getQuantidade());
            itemVendaExistente.setProduto(itemVenda.getProduto());
            itemVendaExistente.setPrecoUnit(itemVenda.getPrecoUnit());
            return itemVendaRepository.save(itemVendaExistente);
        } else {
            return null;
        }
    }


    public void deleteItemVenda(Long id) {
        itemVendaRepository.deleteById(id);
    }
}
