package com.rpg.rpg_api.factory;

import com.rpg.rpg_api.model.Personagem;
import com.rpg.rpg_api.model.enums.Classe;
import com.rpg.rpg_api.model.enums.Status;
import org.springframework.stereotype.Component;

@Component
public class PersonagemFactory {

    public Personagem criarPersonagem(String nome, Classe classe) {
        return switch (classe) {
            case GUERREIRO -> criarGuerreiro(nome);
            case MAGO -> criarMago(nome);
            case ARQUEIRO -> criarArqueiro(nome);
        };
    }

    private Personagem criarGuerreiro(String nome) {
        return new Personagem.Builder()
            .nome(nome)
            .nivel(1)
            .experiencia(0)
            .vida(150)
            .vidaMaxima(150)
            .mana(30)
            .manaMaxima(30)
            .ataque(35)
            .defesa(30)
            .velocidade(15)
            .classe(Classe.GUERREIRO)
            .status(Status.VIVO)
            .build();
    }

    private Personagem criarMago(String nome) {
        return new Personagem.Builder()
            .nome(nome)
            .nivel(1)
            .experiencia(0)
            .vida(80)
            .vidaMaxima(80)
            .mana(150)
            .manaMaxima(150)
            .ataque(50)
            .defesa(10)
            .velocidade(20)
            .classe(Classe.MAGO)
            .status(Status.VIVO)
            .build();
    }

    private Personagem criarArqueiro(String nome) {
        return new Personagem.Builder()
            .nome(nome)
            .nivel(1)
            .experiencia(0)
            .vida(100)
            .vidaMaxima(100)
            .mana(60)
            .manaMaxima(60)
            .ataque(40)
            .defesa(20)
            .velocidade(40)
            .classe(Classe.ARQUEIRO)
            .status(Status.VIVO)
            .build();
    }
}
