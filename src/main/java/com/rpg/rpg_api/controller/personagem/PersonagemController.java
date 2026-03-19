package com.rpg.rpg_api.controller.personagem;

import com.rpg.rpg_api.dto.request.PersonagemRequest;
import com.rpg.rpg_api.model.Personagem;
import com.rpg.rpg_api.service.personagem.PersonagemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {
    private final PersonagemService personagemService;

    public PersonagemController(PersonagemService personagemService) {
        this.personagemService = personagemService;
    }

    @PostMapping
    public ResponseEntity<Personagem> criarPersonagem(@RequestBody @Valid PersonagemRequest personagemRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personagemService.criar(personagemRequest.getNome(), personagemRequest.getClasse()));
    }

    @GetMapping
    public ResponseEntity<List<Personagem>> listarPersonagens() {
        return ResponseEntity.ok().body(personagemService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personagem> buscarPersonagemPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(personagemService.buscarOuFalhar(id));
    }
}
