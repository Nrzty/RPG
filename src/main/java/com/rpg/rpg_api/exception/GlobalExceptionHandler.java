package com.rpg.rpg_api.exception;

import com.rpg.rpg_api.exception.personagem.PersonagemNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(PersonagemNaoEncontradoException.class)
    public ResponseEntity<String> handlePersonagemNaoEncontrado(PersonagemNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
