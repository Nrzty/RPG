package com.rpg.rpg_api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Batalha {
    private Long id;

    private Personagem atacante;
    private Personagem defensor;
    private Personagem vencedor;
    private Personagem perdedor;

    private int turnosSimulados;

    private List<String> logDaBatalha = new ArrayList<>();

    private LocalDateTime dataHora;

    public Batalha() {

    }

    public Long getId() {
        return id;
    }

    public Personagem getAtacante() {
        return atacante;
    }

    public Personagem getDefensor() {
        return defensor;
    }

    public Personagem getVencedor() {
        return vencedor;
    }

    public Personagem getPerdedor() {
        return perdedor;
    }

    public int getTurnosSimulados() {
        return turnosSimulados;
    }

    public List<String> getLogDaBatalha() {
        return logDaBatalha;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAtacante(Personagem atacante) {
        this.atacante = atacante;
    }

    public void setDefensor(Personagem defensor) {
        this.defensor = defensor;
    }

    public void setVencedor(Personagem vencedor) {
        this.vencedor = vencedor;
    }

    public void setPerdedor(Personagem perdedor) {
        this.perdedor = perdedor;
    }

    public void setTurnosSimulados(int turnosSimulados) {
        this.turnosSimulados = turnosSimulados;
    }

    public void setLogDaBatalha(List<String> logDaBatalha) {
        this.logDaBatalha = logDaBatalha;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public static class Builder {

        private Long id;

        private Personagem atacante;
        private Personagem defensor;
        private Personagem vencedor;
        private Personagem perdedor;

        private int turnosSimulados;

        private List<String> logDaBatalha = new ArrayList<>();

        private LocalDateTime dataHora;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder atacante(Personagem atacante) {
            this.atacante = atacante;
            return this;
        }

        public Builder defensor(Personagem defensor) {
            this.defensor = defensor;
            return this;
        }

        public Builder vencedor(Personagem vencedor) {
            this.vencedor = vencedor;
            return this;
        }

        public Builder perdedor(Personagem perdedor) {
            this.perdedor = perdedor;
            return this;
        }

        public Builder turnosSimulados(int turnosSimulados) {
            this.turnosSimulados = turnosSimulados;
            return this;
        }

        public Builder logDaBatalha(List<String> logDaBatalha) {
            this.logDaBatalha = logDaBatalha;
            return this;
        }

        public Builder dataHora(LocalDateTime dataHora) {
            this.dataHora = dataHora;
            return this;
        }

        public Batalha build() {
            Batalha b = new Batalha();
            b.id = this.id;
            b.atacante = this.atacante;
            b.defensor = this.defensor;
            b.vencedor = this.vencedor;
            b.perdedor = this.perdedor;
            b.turnosSimulados = this.turnosSimulados;
            b.logDaBatalha = this.logDaBatalha;
            b.dataHora = this.dataHora;
            return b;
        }
    }
}
