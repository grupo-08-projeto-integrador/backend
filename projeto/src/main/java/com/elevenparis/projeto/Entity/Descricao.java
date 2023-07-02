package com.elevenparis.projeto.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "descricao", schema = "public")
public class Descricao extends AbstractEntity {

    @Getter @Setter
    @Column(name = "material")
    private String material;

    @Getter @Setter
    @Column(name = "cor")
    private String cor;

    @Getter @Setter
    @Column(name = "tamanhos")
    private String tamanhos;

    @Getter @Setter
    @Column(name = "marca")
    private String marca;
}
