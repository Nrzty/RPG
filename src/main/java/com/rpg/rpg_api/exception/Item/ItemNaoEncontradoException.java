package com.rpg.rpg_api.exception.Item;

public class ItemNaoEncontradoException extends RuntimeException {
    public ItemNaoEncontradoException(Long id) {
        super("Item não encontrado: " + id);
    }
}
