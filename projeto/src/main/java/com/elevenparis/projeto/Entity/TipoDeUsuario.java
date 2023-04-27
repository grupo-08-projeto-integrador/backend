package com.elevenparis.projeto.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tipodeusuario", schema = "public")
public class TipoDeUsuario extends AbstractEntity {

    private String cliente;

    private String administrador;


}
