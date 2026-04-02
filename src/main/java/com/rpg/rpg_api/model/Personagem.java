package com.rpg.rpg_api.model;

import com.rpg.rpg_api.model.enums.Classe;
import com.rpg.rpg_api.model.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Personagem {

    private Long id;
    private String nome;
    private int nivel;
    private int experiencia;
    private int vida;
    private int vidaMaxima;
    private int mana;
    private int manaMaxima;
    private int ataque;
    private int defesa;
    private int velocidade;
    private Classe classe;
    private Status status;
    private List<Item> itens;

    private Personagem() {
    }

    public void receberDano(int dano){
        int danoEfetivo = Math.max(0, dano);
        this.vida -= danoEfetivo;

        if (this.vida <= 0) {
            this.vida = 0;
            this.status = Status.MORTO;
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getMana() {
        return mana;
    }

    public int getManaMaxima() {
        return manaMaxima;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public Classe getClasse() {
        return classe;
    }

    public Status getStatus() {
        return status;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public void setManaMaxima(int manaMaxima) {
        this.manaMaxima = manaMaxima;
    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    public static class Builder {
        private Long id;
        private String nome;
        private int nivel;
        private int experiencia;
        private int vida;
        private int vidaMaxima;
        private int mana;
        private int manaMaxima;
        private int ataque;
        private int defesa;
        private int velocidade;
        private Classe classe;
        private Status status;
        private List<Item> itens = new ArrayList<>();

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder nivel(int nivel) {
            this.nivel = nivel;
            return this;
        }

        public Builder experiencia(int experiencia) {
            this.experiencia = experiencia;
            return this;
        }

        public Builder vida(int vida) {
            this.vida = vida;
            return this;
        }

        public Builder vidaMaxima(int vidaMaxima) {
            this.vidaMaxima = vidaMaxima;
            return this;
        }

        public Builder mana(int mana) {
            this.mana = mana;
            return this;
        }

        public Builder manaMaxima(int manaMaxima) {
            this.manaMaxima = manaMaxima;
            return this;
        }

        public Builder ataque(int ataque) {
            this.ataque = ataque;
            return this;
        }

        public Builder defesa(int defesa) {
            this.defesa = defesa;
            return this;
        }

        public Builder velocidade(int velocidade) {
            this.velocidade = velocidade;
            return this;
        }

        public Builder classe(Classe classe) {
            this.classe = classe;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Builder itens(List<Item> itens) {
            this.itens = itens;
            return this;
        }

        public Personagem build() {
            if (nome == null || nome.isBlank())
                throw new IllegalArgumentException("Nome não pode ser vazio");
            if (classe == null)
                throw new IllegalArgumentException("Classe não pode ser nula");

            Personagem p = new Personagem();
            p.id = this.id;
            p.nome = this.nome;
            p.nivel = this.nivel;
            p.experiencia = this.experiencia;
            p.vida = this.vida;
            p.vidaMaxima = this.vidaMaxima;
            p.mana = this.mana;
            p.manaMaxima = this.manaMaxima;
            p.ataque = this.ataque;
            p.defesa = this.defesa;
            p.velocidade = this.velocidade;
            p.classe = this.classe;
            p.status = this.status;
            p.itens = this.itens;
            return p;
        }
    }
}