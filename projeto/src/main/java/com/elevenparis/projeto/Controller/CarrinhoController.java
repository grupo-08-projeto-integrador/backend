package com.elevenparis.projeto.Controller;

import com.elevenparis.projeto.Entity.Carrinho;
import com.elevenparis.projeto.Repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private final CarrinhoRepository carrinhoRepository;

    @Autowired
    public CarrinhoController(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    @GetMapping
    public ResponseEntity<List<Carrinho>> getAllCarrinhos() {
        List<Carrinho> carrinhos = carrinhoRepository.findAll();
        return new ResponseEntity<>(carrinhos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrinho> getCarrinhoById(@PathVariable Long id) {
        Carrinho carrinho = carrinhoRepository.findById(id).orElse(null);
        if (carrinho != null) {
            return new ResponseEntity<>(carrinho, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Carrinho> createCarrinho(@RequestBody Carrinho carrinho) {
        Carrinho createdCarrinho = carrinhoRepository.save(carrinho);
        return new ResponseEntity<>(createdCarrinho, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrinho> updateCarrinho(@PathVariable Long id, @RequestBody Carrinho carrinho) {
        Carrinho existingCarrinho = carrinhoRepository.findById(id).orElse(null);
        if (existingCarrinho != null) {
            existingCarrinho.setItems(carrinho.getItems());
            existingCarrinho.setPrecoTotal(carrinho.getPrecoTotal());
            existingCarrinho.setComprar(carrinho.getComprar());
            existingCarrinho.setFormaPagamento(carrinho.getFormaPagamento());
            existingCarrinho.setComprovantePagamento(carrinho.getComprovantePagamento());
            Carrinho updatedCarrinho = carrinhoRepository.save(existingCarrinho);
            return new ResponseEntity<>(updatedCarrinho, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrinho(@PathVariable Long id) {
        Carrinho carrinho = carrinhoRepository.findById(id).orElse(null);
        if (carrinho != null) {
            carrinhoRepository.delete(carrinho);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
