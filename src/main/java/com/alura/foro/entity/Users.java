package com.alura.foro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String user;
    private String password;



}
