package com.elevenparis.projeto.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ItemProduto", schema = "public")
public class ItemProduto extends AbstractEntity{


    @Getter @Setter
    @Column(name = "cor")
    private String cor;

    @Getter @Setter
    @Column(name = "tamanho")
    private String tamanho;

    @Getter @Setter
    @Column(name = "quantidade")
    private int quantidade;
}
