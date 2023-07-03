package com.elevenparis.projeto.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

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
    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @Getter @Setter
    @Column(name = "imagem")
    //@OneToMany
    private String imagem;

    @Getter @Setter
    @Column(name = "categoria")
    private String categoria;
}
