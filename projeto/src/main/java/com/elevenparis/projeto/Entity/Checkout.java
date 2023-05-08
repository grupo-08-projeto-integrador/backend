package com.elevenparis.projeto.Entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Checkout", schema = "public")
public class Checkout extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    private double precoTotal;

    @Getter @Setter
    private String comprar;

    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Checkout",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "checkout.id",
                            "itemVenda.id"
                    }
            ),
            joinColumns = @JoinColumn(
                    name = "checkout.id"
            ),

            inverseJoinColumns = @JoinColumn(
                    name = "itemVenda.id"
            )
    )
    private List<ItemVenda> items;
}
