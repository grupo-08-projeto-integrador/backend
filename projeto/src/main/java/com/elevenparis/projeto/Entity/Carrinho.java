package com.elevenparis.projeto.Entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "Carrinho", schema = "public")
public class Carrinho extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Carrinho_ItemVenda",
            joinColumns = @JoinColumn(name = "carrinho_id"),
            inverseJoinColumns = @JoinColumn(name = "itemVenda_id")
    )
    @Getter @Setter
    private List<ItemVenda> items;

    @Getter @Setter
    private double precoTotal;

    @Getter @Setter
    private String comprar;

    @Getter @Setter
    private String formaPagamento;

    @Getter @Setter
    private String comprovantePagamento;
}

