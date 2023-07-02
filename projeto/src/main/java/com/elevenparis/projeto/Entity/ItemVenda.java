package com.elevenparis.projeto.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ItemVenda", schema = "public")
public class ItemVenda extends AbstractEntity{

    @Getter @Setter
    private int quantidade;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Getter @Setter
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Getter @Setter
    private double precoUnit;
}
