package com.elevenparis.projeto.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "usuarios", schema = "public")
public class Usuario extends AbstractEntity{

    @Getter @Setter
    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;

    @Getter @Setter
    @Column(name = "password", nullable = false,length = 50)
    private String password;

    @Getter @Setter
    @Column(name = "email", nullable = false, unique = true,length = 50)
    private String email;

    @Getter @Setter
    @Column(name = "tipodeusuario", nullable = false, unique = false,length = 50)
    private String tipodeusuario;

}

