package com.elevenparis.projeto.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios", schema = "public")
public class Usuario extends AbstractEntity{
@Id
    @Getter @Setter
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Getter @Setter
    @Column(name = "password", nullable = false)
    private String password;
    @Getter @Setter
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Getter @Setter
    @Column(name = "tipodeusuario", nullable = false, unique = false)
    private String tipodeusuario;

}

