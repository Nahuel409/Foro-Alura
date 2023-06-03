package com.alura.foro.controller;

import com.alura.foro.dto.DatosUsuario;
import com.alura.foro.entity.Usuario;
import com.alura.foro.security.AuthenticationService;
import com.alura.foro.security.DatosJWTtoken;
import com.alura.foro.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationUsuarioController {

    @Autowired
   AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody DatosUsuario datosUsuario){
        Authentication AuthToken = new UsernamePasswordAuthenticationToken(datosUsuario.email(),datosUsuario.Password());
       var usuarioAutenticado =  authenticationManager.authenticate(AuthToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return new ResponseEntity<>(new DatosJWTtoken(JWTtoken), HttpStatus.OK);
    }

}
