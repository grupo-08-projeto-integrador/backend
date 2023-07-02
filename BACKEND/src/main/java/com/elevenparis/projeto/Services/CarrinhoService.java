package com.elevenparis.projeto.Services;

import com.elevenparis.projeto.Entity.Carrinho;
import com.elevenparis.projeto.Repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;

    @Autowired
    public CarrinhoService(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    public List<Carrinho> getAllCarrinhos() {
        return carrinhoRepository.findAll();
    }

    public Carrinho getCarrinhoById(Long id) {
        return carrinhoRepository.findById(id).orElse(null);
    }

    public Carrinho createCarrinho(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    public Carrinho updateCarrinho(Long id, Carrinho carrinho) {
        Carrinho existingCarrinho = carrinhoRepository.findById(id).orElse(null);
        if (existingCarrinho != null) {
            existingCarrinho.setItems(carrinho.getItems());
            existingCarrinho.setPrecoTotal(carrinho.getPrecoTotal());
            existingCarrinho.setComprar(carrinho.getComprar());
            existingCarrinho.setFormaPagamento(carrinho.getFormaPagamento());
            existingCarrinho.setComprovantePagamento(carrinho.getComprovantePagamento());
            return carrinhoRepository.save(existingCarrinho);
        }
        return null;
    }

    public void deleteCarrinho(Long id) {
        carrinhoRepository.deleteById(id);
    }
}
