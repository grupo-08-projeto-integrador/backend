package com.elevenparis.projeto.Entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "barra_de_busca", schema = "public")
public class BarraDeBusca extends AbstractEntity {
    @Id
    @Getter
    private String input;

    @ManyToMany
    @Getter @Setter
    private List<Produto> resultado;

    @Getter @Setter
    private String fieldType;
}
