package com.elevenparis.projeto.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produto", schema = "public")
public class Produto extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
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
    @OneToMany
    private String imagem;

    @Getter @Setter
    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Getter @Setter
    @Column(name = "estado", nullable = false)
    private String estado;
}
