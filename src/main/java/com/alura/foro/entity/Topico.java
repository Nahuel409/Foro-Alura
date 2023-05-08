package com.alura.foro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@Entity
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(unique = true)
    @NotNull
    private String titulo;
    @Column(unique = true)
    @NotNull
    private String mensaje;
    @NotNull
    private String curso;


    public Topico() {
    }

    public Topico(String titulo, String mensaje, String curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.curso = curso;
    }
}
