package com.elevenparis.projeto.Controller;

import com.elevenparis.projeto.Entity.Usuario;
import com.elevenparis.projeto.Repository.UsuarioRepository;
import jakarta.persistence.Id;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.usuarioRepository.findById(id).orElse(new Usuario()));
    }
/*
    @GetMapping("/{tipodeusuario}/{id}")
    public ResponseEntity<Usuario> getUser(@PathVariable String tipodeusuario, @PathVariable Long id) {
        Usuario usuario = null;
        if (tipodeusuario.equals("admin")) {
            // busca um usuário como administrador
            usuario = usuarioService.findUserByIdAsAdmin(id);
        } else if (tipodeusuario.equals("client")) {
            // busca um usuário como cliente
            usuario = usuarioService.findUserByIdAsClient(id);
        }
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(usuario);
        }
    }

 */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Usuario usuario){
        if (usuario.equals(usuario.getId()) && !this.usuarioRepository.findById(usuario.getId()).isEmpty()) {
            return ResponseEntity.ok().build();
        }
        this.usuarioRepository.save(usuario);
        return ResponseEntity.ok().body("Atualizado Com Sucesso");

    }

    @PostMapping
    public ResponseEntity<?> cadastro(@RequestBody Usuario usuario){
        this.usuarioRepository.save(usuario);
        return ResponseEntity.ok().body("Cadastro Efetuado com Sucesso ");
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
