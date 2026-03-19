package com.rpg.rpg_api.service.item;

import com.rpg.rpg_api.dto.request.ItemRequest;
import com.rpg.rpg_api.model.Item;
import com.rpg.rpg_api.model.enums.item.RaridadeItem;
import com.rpg.rpg_api.model.enums.item.TipoItem;

import java.util.List;

public interface ItemService {
    Item criar(ItemRequest itemRequest);

    List<Item> buscarTodos();

    Item buscarOuFalhar(Long id);

    List<Item> filtrarPorRaridade(RaridadeItem raridadeItem);
}
