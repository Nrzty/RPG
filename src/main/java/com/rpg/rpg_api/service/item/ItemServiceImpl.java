package com.rpg.rpg_api.service.item;

import com.rpg.rpg_api.dto.request.ItemRequest;
import com.rpg.rpg_api.exception.Item.ItemNaoEncontradoException;
import com.rpg.rpg_api.model.Item;
import com.rpg.rpg_api.model.enums.item.RaridadeItem;
import com.rpg.rpg_api.repository.item.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item criar(ItemRequest itemRequest) {
        Item item = new Item.Builder()
                .nome(itemRequest.getNome())
                .descricao(itemRequest.getDescricao())
                .tipoItem(itemRequest.getTipoItem())
                .raridadeItem(itemRequest.getRaridadeItem())
                .bonusAtaque(itemRequest.getBonusAtaque())
                .bonusDefesa(itemRequest.getBonusDefesa())
                .bonusVida(itemRequest.getBonusVida())
                .bonusMana(itemRequest.getBonusMana())
                .build();
        return itemRepository.salvar(item);
    }

    @Override
    public List<Item> buscarTodos() {
        return itemRepository.buscarTodos();
    }

    @Override
    public Item buscarOuFalhar(Long id) {
        return itemRepository.buscarPorId(id).orElseThrow(() -> new ItemNaoEncontradoException(id));
    }

    @Override
    public List<Item> filtrarPorRaridade(RaridadeItem raridade) {
        return itemRepository.buscarTodos().stream().filter(item -> item.getRaridadeItem().equals(raridade)).toList();
    }
}
