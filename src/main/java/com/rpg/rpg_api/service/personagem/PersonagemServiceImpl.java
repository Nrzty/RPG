package com.rpg.rpg_api.service.personagem;

import com.rpg.rpg_api.factory.PersonagemFactory;
import com.rpg.rpg_api.model.Personagem;
import com.rpg.rpg_api.model.enums.Classe;
import com.rpg.rpg_api.repository.personagem.PersonagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemServiceImpl implements PersonagemService {

    private final PersonagemFactory personagemFactory;
    private final PersonagemRepository personagemRepository;

    public PersonagemServiceImpl(PersonagemFactory personagemFactory, PersonagemRepository personagemRepository) {
        this.personagemFactory = personagemFactory;
        this.personagemRepository = personagemRepository;
    }

    @Override
    public Personagem criar(String nome, Classe classe) {
        Personagem personagem = personagemFactory.criarPersonagem(nome, classe);
        return personagemRepository.salvar(personagem);
    }

    @Override
    public List<Personagem> listarTodos() {
        return personagemRepository.buscarTodos();
    }

    @Override
    public Personagem buscarOuFalhar(Long id) {
        return personagemRepository.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Personagem não encontrado!"));
    }
}
