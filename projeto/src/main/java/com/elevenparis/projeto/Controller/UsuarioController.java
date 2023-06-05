package com.elevenparis.projeto.Controller;

import com.elevenparis.projeto.Entity.Usuario;
import com.elevenparis.projeto.Repository.UsuarioRepository;
import com.elevenparis.projeto.Services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    public UsuarioController(UsuarioService usuarioService, UsuarioRepository usuarioRepository){
    this.usuarioService = usuarioService;
    this.usuarioRepository = usuarioRepository;
}
    private UsuarioRepository usuarioRepository;
    private UsuarioService usuarioService;



    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Usuario usuario){
        if (!usuario.getId().equals(id)) {
            return ResponseEntity.badRequest().body("ID do usuário na URL difere do ID do usuário no corpo da requisição");
        }
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().body("Usuário atualizado com sucesso");
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Usuario usuario){
        try{
            usuarioService.cadastrar(usuario);
            return ResponseEntity.ok().body("Cadastro efetuado com sucesso");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        Optional<Usuario> optionalUser = usuarioRepository.findById(id);
        if (optionalUser.isPresent()) {
            Usuario usuario = optionalUser.get();
            usuarioRepository.delete(usuario);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
