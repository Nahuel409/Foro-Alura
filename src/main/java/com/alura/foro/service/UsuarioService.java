package com.alura.foro.service;

import com.alura.foro.entity.Usuario;
import com.alura.foro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
  @Autowired
   private UsuarioRepository usuarioRepository;

    public Usuario crearUsuario(Usuario usuario){

        return usuarioRepository.save(usuario);
    }
    public List<Usuario> listaUsuarios(){

        return usuarioRepository.findAll();
    }


    public Usuario editarUsuario(Long id, Usuario usuario){
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
        if(usuarioEncontrado.isPresent()){
            Usuario user = usuarioEncontrado.get();

            user.setNombre(usuario.getNombre());
            user.setApellido(usuario.getApellido());
            user.setEmail(usuario.getEmail());
            user.setPassword(usuario.getPassword());
            return usuarioRepository.save(user);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario con id "+id+" no existe");
        }
    }


    public void eliminarUsuario(Long id){
      Optional<Usuario> usuario = usuarioRepository.findById(id);
      if(usuario.isPresent()){
        usuarioRepository.deleteById(id);
      }else{
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"el usuario con id "+id+" no existe");
      }

    }

}
