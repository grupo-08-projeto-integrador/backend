package com.elevenparis.projeto.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categoria", schema = "public")
public class Categoria extends AbstractEntity{
    @Getter @Setter
    private String camisa;

    @Getter @Setter
    private String camiseta;

    @Getter @Setter
    private String calca;

    @Getter @Setter
    private String shorts;

    @Getter @Setter
    private String tenis;

    @Getter @Setter
    private String blusa;

}
