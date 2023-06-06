package com.elevenparis.projeto.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produto", schema = "public")
public class Produto extends AbstractEntity {
    @Getter @Setter
    @Column(name = "nome")
    private String nome;

    @Getter @Setter
    @Column(name = "descricao")
    private String descricao;

    @Getter @Setter
    @Column(name = "preco")
    private double preco;

    @Getter @Setter
    @Column(name = "imagem")
    //@OneToMany
    private String imagem;

    @Getter @Setter
    @Column(name = "categoria")
    private String categoria;

    @Getter @Setter
    @Column(name = "estado")
    private String estado;
}
