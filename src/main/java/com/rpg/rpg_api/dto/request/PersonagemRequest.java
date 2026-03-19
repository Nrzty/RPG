package com.rpg.rpg_api.dto.request;

import com.rpg.rpg_api.model.enums.Classe;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PersonagemRequest {
    @NotBlank(message = "O nome não pode estar em branco")
    private String nome;

    @NotNull(message =  "Você deve escolher uma das classes disponíveis")
    private Classe classe;

    public String getNome() {
        return nome;
    }

    public PersonagemRequest(String nome, Classe classe) {
        this.nome = nome;
        this.classe = classe;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
