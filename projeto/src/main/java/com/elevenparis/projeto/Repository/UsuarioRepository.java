package com.elevenparis.projeto.Repository;

import com.elevenparis.projeto.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query
    List<Usuario> findAllByusername(@Param ("username")String username);

    @Query
    List<Usuario> findAllBytipodeusuario(@Param("tipodeusuario")String tipodeusuario);

    Usuario findByEmail(String email);
}
