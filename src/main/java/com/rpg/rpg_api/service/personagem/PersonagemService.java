package com.rpg.rpg_api.service.personagem;

import com.rpg.rpg_api.model.Personagem;
import com.rpg.rpg_api.model.enums.Classe;

import java.util.List;

public interface PersonagemService {
    Personagem criar(String nome, Classe classe);

    List<Personagem> listarTodos();

    Personagem buscarOuFalhar(Long id);
}
