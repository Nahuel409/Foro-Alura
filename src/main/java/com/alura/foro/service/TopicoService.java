package com.alura.foro.service;

import com.alura.foro.entity.Topico;
import com.alura.foro.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    TopicoRepository topicoRepository;

    public List<Topico> verTopicos(){
       return topicoRepository.findAll();
    }

    public Topico crearTopico(Topico topico){
        return topicoRepository.save(topico);
    }

    public Topico editarTopico(Long id, Topico topico){
        Optional<Topico> topic = topicoRepository.findById(id);
        if(topic.isPresent()){
            Topico topicoEditado = topic.get();
            topicoEditado.setTitulo(topico.getTitulo());
            topicoEditado.setMensaje(topico.getMensaje());
            topicoEditado.setCurso(topico.getCurso());
                return topicoRepository.save(topicoEditado);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El topico con ID "+ id +" no existe");
        }
    }


    public void eliminarTopico(Long id){
        Optional<Topico> existe = topicoRepository.findById(id);
        if(existe.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El topico con ID "+ id +" no existe");
        }else{
            topicoRepository.deleteById(id);
        }
    }



}
