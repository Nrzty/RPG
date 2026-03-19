package com.rpg.rpg_api.repository.item;

import com.rpg.rpg_api.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    Item salvar(Item item);

    List<Item> buscarTodos();

    Optional<Item> buscarPorId(Long id);
}
