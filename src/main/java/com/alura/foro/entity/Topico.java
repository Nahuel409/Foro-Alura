package com.alura.foro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(unique = true)
    @NotBlank
    private String titulo;
    @Column(unique = true)
    @NotBlank
    private String mensaje;
    @NotBlank
    private String autor;
    private LocalDateTime fecha = LocalDateTime.now();
    @NotBlank
    private String curso;
    @NotNull
    private Estado estado;



}
