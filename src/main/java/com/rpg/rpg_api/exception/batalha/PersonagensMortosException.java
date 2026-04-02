package com.rpg.rpg_api.exception.batalha;

public class PersonagensMortosException extends RuntimeException {
    public PersonagensMortosException() {
        super("Não foi possível iniciar a batalha pois os participantes estão mortos");
    }
}
