package com.elevenparis.projeto.Controller;


import com.elevenparis.projeto.Entity.Produto;
import com.elevenparis.projeto.Repository.ProdutoRepository;
import com.elevenparis.projeto.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;


    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdRequest(@PathVariable("id") final Long id) {

        final Produto produto = this.produtoRepository.findById(id).orElse(null);
        return produto == null
                ? ResponseEntity.badRequest().body("Nenhum valor Encontrado")
                : ResponseEntity.ok(produto);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> listaCompleta() {
        return ResponseEntity.ok(this.produtoRepository.findAll());
    }

    @GetMapping("/ativo")
    public ResponseEntity<?> ListaAtivo() {
        return ResponseEntity.ok(this.produtoRepository.findAtivo());
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Produto produto) {
        try {
            this.produtoService.cadastrar(produto);
            return ResponseEntity.ok("REGISTRO CADASTRADO COM SUCESSO");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("erro > " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestParam("id") final Long id, @RequestBody final Produto produto) {
        try {
            this.produtoService.editar(id, produto);
            return ResponseEntity.ok("sucesso >" + produto);

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.internalServerError().body("erro" + e.getCause().getCause().getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body("erro" + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleta(@RequestParam("id") final Long id) {
        final Produto produto = this.produtoRepository.findById(id).orElse(null);

        this.produtoService.deleta(produto);

        return ResponseEntity.ok("Produto deletado");
    }
}