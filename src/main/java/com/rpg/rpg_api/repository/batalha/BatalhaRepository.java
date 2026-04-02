package com.rpg.rpg_api.repository.batalha;

import com.rpg.rpg_api.model.Batalha;

import java.util.List;
import java.util.Optional;

public interface BatalhaRepository {
    Batalha salvar(Batalha batalha);

    List<Batalha> buscarPorPersonagem(Long personagemId);

    Optional<Batalha> buscarPorId(Long id);
}
