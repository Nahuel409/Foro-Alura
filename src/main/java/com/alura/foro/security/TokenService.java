package com.alura.foro.security;

import com.alura.foro.entity.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario){
        try {
        Algorithm algorithm = Algorithm.HMAC256(apiSecret);
        return JWT.create()
                .withIssuer("foro alura")
                .withSubject(usuario.getEmail())
                .withClaim("id",usuario.getId())
                .withExpiresAt(expiracion())
                .sign(algorithm);
    } catch (JWTCreationException exception){
        throw new RuntimeException(exception);
        }
    }

    private Instant expiracion(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }

}
