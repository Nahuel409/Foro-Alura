package com.alura.foro.repository;

import com.alura.foro.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TopicoRepository extends JpaRepository<Topico,Long> {
}
