package com.rpg.rpg_api.controller.item;

import com.rpg.rpg_api.dto.request.ItemRequest;
import com.rpg.rpg_api.model.Item;
import com.rpg.rpg_api.model.enums.item.RaridadeItem;
import com.rpg.rpg_api.service.item.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Item> criarItem(@RequestBody @Valid ItemRequest itemRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.criar(itemRequest));
    }

    @GetMapping
    public ResponseEntity<List<Item>> listarItens() {
        return ResponseEntity.ok().body(itemService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> buscarItemPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(itemService.buscarOuFalhar(id));
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<Item>> filtrarPorRaridade(@RequestParam RaridadeItem raridadeItem) {
        return ResponseEntity.ok().body(itemService.filtrarPorRaridade(raridadeItem));
    }
}