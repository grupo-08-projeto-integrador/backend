package com.elevenparis.projeto.Services;

import com.elevenparis.projeto.Entity.Usuario;
import com.elevenparis.projeto.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario criarUsuario(Usuario usuario) {
        if(usuario.getUsername().isEmpty()){
            throw new IllegalArgumentException("Usuario Não Informado");
        }
        if (!usuario.getUsername().matches("[a-zA-Z ]")){
            throw new IllegalArgumentException("Usuario Com Caracteres Não Aceitos");
        }


        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente == null) {
            return null;
        } else {
            usuarioExistente.setUsername(usuarioAtualizado.getUsername());
            usuarioExistente.setEmail(usuarioAtualizado.getEmail());
            return usuarioRepository.save(usuarioExistente);
        }
    }

    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
    @Transactional(rollbackFor = Exception.class)
    public void cadastrar(Usuario usuario){
        criarUsuario(usuario);
        usuarioRepository.save(usuario);
    }
}
