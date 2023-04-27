package com.elevenparis.projeto.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable //
public class Tamanhos {
    @Getter @Setter
    @Column(name = "p")
    private String p;

    @Getter @Setter
    @Column(name = "m")
    private String m;

    @Getter @Setter
    @Column(name = "g")
    private String g;

    @Getter @Setter
    @Column(name = "gg")
    private String gg;

    @Getter @Setter
    @Column(name = "xgg")
    private String xgg;
}
