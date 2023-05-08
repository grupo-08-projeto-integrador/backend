package com.elevenparis.projeto.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categoria", schema = "public")
public class Categoria extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

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
