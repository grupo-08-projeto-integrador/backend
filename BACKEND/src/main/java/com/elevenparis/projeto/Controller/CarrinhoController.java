package com.elevenparis.projeto.Controller;

import com.elevenparis.projeto.Entity.Carrinho;
import com.elevenparis.projeto.Services.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    @Autowired
    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Carrinho>> getAllCarrinhos() {
        List<Carrinho> carrinhos = carrinhoService.getAllCarrinhos();
        return new ResponseEntity<>(carrinhos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrinho> getCarrinhoById(@PathVariable Long id) {
        Carrinho carrinho = carrinhoService.getCarrinhoById(id);
        if (carrinho != null) {
            return new ResponseEntity<>(carrinho, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Carrinho> createCarrinho(@RequestBody Carrinho carrinho) {
        Carrinho createdCarrinho = carrinhoService.createCarrinho(carrinho);
        return new ResponseEntity<>(createdCarrinho, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrinho> updateCarrinho(@PathVariable Long id, @RequestBody Carrinho carrinho) {
        Carrinho updatedCarrinho = carrinhoService.updateCarrinho(id, carrinho);
        if (updatedCarrinho != null) {
            return new ResponseEntity<>(updatedCarrinho, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrinho(@PathVariable Long id) {
        carrinhoService.deleteCarrinho(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
