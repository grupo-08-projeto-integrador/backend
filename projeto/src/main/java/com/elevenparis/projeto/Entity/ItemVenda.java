package com.elevenparis.projeto.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ItemVenda", schema = "public")
public class ItemVenda extends AbstractEntity{


    @Getter @Setter
    private int quantidade;

    @ManyToOne
    @Getter @Setter
    private Produto produto;

    @Getter @Setter
    private double precoUnit;
}
