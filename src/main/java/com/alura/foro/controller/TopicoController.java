package com.alura.foro.controller;

import com.alura.foro.entity.Topico;
import com.alura.foro.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public List<Topico> verTopicos(){
        return topicoService.verTopicos();
    }

    @PostMapping
    public ResponseEntity<Topico> crearTopico(@RequestBody @Valid Topico topico){
        Topico topic = topicoService.crearTopico(topico);
        return new ResponseEntity<>(topic,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico>editarTopico(@PathVariable Long id, @RequestBody Topico topico){
       Topico topic = topicoService.editarTopico(id,topico);
       return new ResponseEntity<>(topic,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>eliminarTopico(@PathVariable Long id){
        topicoService.eliminarTopico(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
