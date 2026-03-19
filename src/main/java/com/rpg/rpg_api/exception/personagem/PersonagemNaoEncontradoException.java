package com.rpg.rpg_api.exception.personagem;

public class PersonagemNaoEncontradoException extends RuntimeException {
    public PersonagemNaoEncontradoException(Long id) {
        super("Personagem não encontrado: " + id);
    }
}
