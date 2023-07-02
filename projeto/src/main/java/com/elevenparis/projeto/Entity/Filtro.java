package com.elevenparis.projeto.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "filtros", schema = "public")
public class Filtro extends AbstractEntity {

    @Getter @Setter
    @Column(name = "nome", nullable = false)
    private String nome;

    @Getter @Setter
    @Column(name = "tamanho")
    private String tamanho;

    @Getter @Setter
    @Column(name = "cor")
    private String cor;

    @Getter @Setter
    @Column(name = "tipo", nullable = false)
    private String tipo;
}
