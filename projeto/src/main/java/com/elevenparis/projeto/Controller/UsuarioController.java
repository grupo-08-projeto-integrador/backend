package com.elevenparis.projeto.Controller;

import com.elevenparis.projeto.Entity.Usuario;
import com.elevenparis.projeto.Repository.UsuarioRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.usuarioRepository.findById(id).orElse(new Usuario()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Usuario usuario){
        if (id.equals(usuario.getId()) && !this.usuarioRepository.findById(id).isEmpty()){return ResponseEntity}
        this.usuarioRepository.save(usuario);
        return ResponseEntity.ok().body("Atualizado Com Sucesso");

    }



}
