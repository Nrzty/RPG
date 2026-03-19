package com.rpg.rpg_api.repository.personagem;

import com.rpg.rpg_api.model.Personagem;

import java.util.List;
import java.util.Optional;

public interface PersonagemRepository {
    Personagem salvar(Personagem personagem);

    List<Personagem> buscarTodos();

    Optional<Personagem> buscarPorId(Long id);
}
