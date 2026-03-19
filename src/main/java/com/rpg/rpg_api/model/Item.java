package com.rpg.rpg_api.model;

import com.rpg.rpg_api.model.enums.item.RaridadeItem;
import com.rpg.rpg_api.model.enums.item.TipoItem;

public class Item {
    private Long id;

    private String nome;
    private String descricao;

    private TipoItem tipoItem;

    private RaridadeItem raridadeItem;

    private int bonusAtaque;
    private int bonusDefesa;
    private int bonusVida;
    private int bonusMana;

    private Item() {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public RaridadeItem getRaridadeItem() {
        return raridadeItem;
    }

    public int getBonusAtaque() {
        return bonusAtaque;
    }

    public int getBonusDefesa() {
        return bonusDefesa;
    }

    public int getBonusVida() {
        return bonusVida;
    }

    public int getBonusMana() {
        return bonusMana;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }

    public void setRaridadeItem(RaridadeItem raridadeItem) {
        this.raridadeItem = raridadeItem;
    }

    public void setBonusAtaque(int bonusAtaque) {
        this.bonusAtaque = bonusAtaque;
    }

    public void setBonusDefesa(int bonusDefesa) {
        this.bonusDefesa = bonusDefesa;
    }

    public void setBonusVida(int bonusVida) {
        this.bonusVida = bonusVida;
    }

    public void setBonusMana(int bonusMana) {
        this.bonusMana = bonusMana;
    }

    public static class Builder {
        private Long id;

        private String nome;
        private String descricao;

        private TipoItem tipoItem;

        private RaridadeItem raridadeItem;

        private int bonusAtaque;
        private int bonusDefesa;
        private int bonusVida;
        private int bonusMana;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder tipoItem(TipoItem tipoItem) {
            this.tipoItem = tipoItem;
            return this;
        }

        public Builder raridadeItem(RaridadeItem raridadeItem) {
            this.raridadeItem = raridadeItem;
            return this;
        }

        public Builder bonusAtaque(int bonusAtaque) {
            this.bonusAtaque = bonusAtaque;
            return this;
        }

        public Builder bonusDefesa(int bonusDefesa) {
            this.bonusDefesa = bonusDefesa;
            return this;
        }

        public Builder bonusVida(int bonusVida) {
            this.bonusVida = bonusVida;
            return this;
        }

        public Builder bonusMana(int bonusMana) {
            this.bonusMana = bonusMana;
            return this;
        }

        public Item build() {
            if (nome == null || nome.isBlank())
                throw new IllegalArgumentException("Nome não pode ser vazio");

            if (tipoItem == null)
                throw new IllegalArgumentException("O tipo do item não pode ser nulo");

            if (raridadeItem == null)
                throw new IllegalArgumentException("A raridade do item deve ter um valor definido");

            Item i = new Item();

            i.id = this.id;
            i.nome = this.nome;
            i.descricao = this.descricao;
            i.tipoItem = this.tipoItem;
            i.raridadeItem = this.raridadeItem;
            i.bonusAtaque = this.bonusAtaque;
            i.bonusDefesa = this.bonusDefesa;
            i.bonusVida = this.bonusVida;
            i.bonusMana = this.bonusMana;
            return i;
        }
    }
}
