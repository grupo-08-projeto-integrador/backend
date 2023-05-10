package com.elevenparis.projeto.Controller;


import com.elevenparis.projeto.Entity.Produto;
import com.elevenparis.projeto.Repository.ProdutoRepository;
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
    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id") final Long id){
        final Produto produto = this.produtoRepository.findById(id).orElse(null);
        return produto == null
                ? ResponseEntity.badRequest().body("Nenhum valor encontrado.")
                : ResponseEntity.ok(produto);
    }

    @GetMapping
    public ResponseEntity<?> findByIdRequest(@RequestParam("id") final Long id){
        final Produto produto = this.produtoRepository.findById(id).orElse(null);
        return produto == null
                ? ResponseEntity.badRequest().body("Nenhum valor encontrado.")
                : ResponseEntity.ok(produto);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> listaCompleta(){
        return ResponseEntity.ok(this.produtoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Produto produto){
        try {
            this.produtoRepository.save(produto);
            return ResponseEntity.ok("Registro Cadastrado com Sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError()
                    .body("Error: " + e.getCause().getCause().getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(
            @RequestParam("id") final Long id,
            @RequestBody final Produto produto
    ){
        try {
            final Produto produtoBanco = this.produtoRepository.findById(id).orElse(null);

            if (produtoBanco == null || !produtoBanco.getId().equals(produto.getId())){
                throw new RuntimeException("Não foi possivel identificar o registro informado.");
            }

            this.produtoRepository.save(produto);
            return ResponseEntity.ok("Registro atualizado com Sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(
            @RequestParam("id") final Long id
    ){
        final Produto produtoBanco = this.produtoRepository.findById(id).orElse(null);

        this.produtoRepository.delete(produtoBanco);
        return ResponseEntity.ok("Registro Excluido com Sucesso");
    }
}
