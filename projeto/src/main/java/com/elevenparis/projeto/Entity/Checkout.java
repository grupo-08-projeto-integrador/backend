package com.elevenparis.projeto.Entity;

import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Checkout", schema = "public")
public class Checkout extends AbstractEntity {
    @Getter @Setter
    private double precoTotal;

    @Getter @Setter
    private String comprar;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Checkout_ItemVenda",
            joinColumns = @JoinColumn(name = "checkout_id"),
            inverseJoinColumns = @JoinColumn(name = "itemVenda_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"checkout_id", "itemVenda_id"})
    )
    private List<ItemVenda> items;
}
