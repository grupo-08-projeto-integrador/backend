package com.elevenparis.projeto.Entity;


import jakarta.persistence.*;
import lombok.Getter;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
}
