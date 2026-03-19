package com.rpg.rpg_api.repository.item;

import com.rpg.rpg_api.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private List<Item> itens = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(0);

    @Override
    public Item salvar(Item item) {
        item.setId(contador.incrementAndGet());
        itens.add(item);
        return item;
    }

    @Override
    public List<Item> buscarTodos() {
        return Collections.unmodifiableList(itens);
    }

    @Override
    public Optional<Item> buscarPorId(Long id) {
        return itens.stream().filter(item -> item.getId().equals(id)).findFirst();
    }
}
