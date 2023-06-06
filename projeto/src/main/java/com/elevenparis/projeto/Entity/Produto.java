package com.elevenparis.projeto.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

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
    private BigDecimal preco;

    @Getter @Setter
    @Column(name = "imagem", nullable = false)
    private String imagem;

    @Getter @Setter
    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Getter @Setter
    @Column(name = "estado", nullable = false)
    private String estado;
}
