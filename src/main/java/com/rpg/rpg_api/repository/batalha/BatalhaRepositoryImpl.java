package com.rpg.rpg_api.repository.batalha;

import com.rpg.rpg_api.model.Batalha;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class BatalhaRepositoryImpl implements BatalhaRepository {

    private final List<Batalha> batalhas = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(0);

    @Override
    public Batalha salvar(Batalha batalha) {
        batalha.setId(contador.incrementAndGet());
        batalhas.add(batalha);
        return batalha;
    }

    @Override
    public List<Batalha> buscarPorPersonagem(Long personagemId) {
        return batalhas
            .stream()
            .filter(
                batalha ->
                    batalha.getAtacante().getId().equals(personagemId) ||
                    batalha.getDefensor().getId().equals(personagemId)
            )
            .toList();
    }

    @Override
    public Optional<Batalha> buscarPorId(Long id) {
        return batalhas
            .stream()
            .filter(batalha -> batalha.getId().equals(id))
            .findFirst();
    }
}
