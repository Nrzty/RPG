package com.rpg.rpg_api.dto.request;

import com.rpg.rpg_api.model.enums.item.RaridadeItem;
import com.rpg.rpg_api.model.enums.item.TipoItem;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ItemRequest {
    @NotBlank(message = "O nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "O nome não pode estar em branco")
    private String descricao;

    @NotNull(message = "O tipo do item deve ser informado")
    private TipoItem tipoItem;

    @NotNull(message = "A raridade do item deve ser informada")
    private RaridadeItem raridadeItem;

    @Min(value = 0, message = "O Bônus precisa ter um valor definido")
    private int bonusAtaque;
    @Min(value = 0, message = "O Bônus precisa ter um valor definido")
    private int bonusDefesa;
    @Min(value = 0, message = "O Bônus precisa ter um valor definido")
    private int bonusVida;
    @Min(value = 0, message = "O Bônus precisa ter um valor definido")
    private int bonusMana;

    private ItemRequest() {

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
}
