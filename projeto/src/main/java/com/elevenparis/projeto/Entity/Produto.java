package com.elevenparis.projeto.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produto", schema = "public")
public class Produto extends AbstractEntity {
    @Getter @Setter
    @Column(name = "nome", nullable = false)
    private String nome;

    @Getter @Setter
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Getter @Setter
    @Column(name = "preco", nullable = false)
    private double preco;

    @Getter @Setter
    @Column(name = "imagem", nullable = false)
    private String imagem;

    @Getter @Setter
    @Column(name = "categoria", nullable = false)
    private String categoria;

}
