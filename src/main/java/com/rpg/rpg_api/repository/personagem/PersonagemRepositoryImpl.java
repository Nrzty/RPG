package com.rpg.rpg_api.repository.personagem;

import com.rpg.rpg_api.model.Personagem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PersonagemRepositoryImpl implements PersonagemRepository{

    private List<Personagem> personagens = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(0);

    @Override
    public Personagem salvar(Personagem personagem) {
        personagem.setId(contador.incrementAndGet());
        personagens.add(personagem);
        return personagem;
    }

    @Override
    public List<Personagem> buscarTodos() {
        return Collections.unmodifiableList(personagens);
    }

    @Override
    public Optional<Personagem> buscarPorId(Long id) {
        return personagens.stream().filter(personagem -> personagem.getId().equals(id)).findFirst();
    }
}
