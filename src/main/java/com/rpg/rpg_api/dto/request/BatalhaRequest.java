package com.rpg.rpg_api.dto.request;

import com.rpg.rpg_api.model.Personagem;
import jakarta.validation.constraints.NotNull;

public class BatalhaRequest {

    @NotNull(message = "É necessário haver um atacante para a batalhar começar")
    private Long atacanteId;

    @NotNull(message = "É necessário haver um defensor para a batalhar começar")
    private Long defensorId;

    private BatalhaRequest() {}

    public Long getAtacanteId() {
        return atacanteId;
    }

    public Long getDefensorId() {
        return defensorId;
    }
}
