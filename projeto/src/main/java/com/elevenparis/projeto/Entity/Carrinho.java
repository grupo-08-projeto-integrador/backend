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
    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Carrinho",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {
                        "carrinho.id",
                        "itemVenda.id"
                }
        ),
            joinColumns = @JoinColumn(
                    name = "carrinho.id"
            ),

            inverseJoinColumns = @JoinColumn(
                    name = "itemVenda.id"
            )
    )
    private List<ItemVenda> items;

    @Getter @Setter
    private double precoTotal;

    @Getter @Setter
    private String comprar;

    @Getter @Setter
    private String formaPagamento;

    @Getter @Setter
    private String ComprovantePagamento;


}
