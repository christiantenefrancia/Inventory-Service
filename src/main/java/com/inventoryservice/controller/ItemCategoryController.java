package com.inventoryservice.controller;

import com.inventoryservice.exception.ResourceNotFoundException;
import com.inventoryservice.domain.ItemCategory;
import com.inventoryservice.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/categories")
public class ItemCategoryController {

    @Autowired
    private ItemCategoryService itemCategoryService;

    @GetMapping
    public List<ItemCategory> findAll() {

        return StreamSupport.stream(itemCategoryService.getItemCategories().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/{itemCategoryId}")
    public ResponseEntity<ItemCategory> findByItemCategoryId (@PathVariable Long itemCategoryId)
            throws ResourceNotFoundException {

        ItemCategory itemCategory = itemCategoryService.getItemCategoryByItemCategoryId(itemCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Item category not found for this id :: " + itemCategoryId));

        return ResponseEntity.ok().body(itemCategory);
    }

    @PostMapping
    public ItemCategory addItemCategory(@RequestBody ItemCategory itemCategory){

        return itemCategoryService.save(itemCategory);
    }

    @PutMapping("/{itemCategoryId}")
    public ResponseEntity updateItemCategory(@PathVariable Long itemCategoryId, @RequestBody ItemCategory itemCategory)
            throws ResourceNotFoundException {

        ItemCategory category =  itemCategoryService.getItemCategoryByItemCategoryId(itemCategoryId)
                .map(s -> {
                    itemCategoryService.save(itemCategory);
                    return s;
                })
                .orElseThrow(() -> new ResourceNotFoundException("Item category not found for this id :: " + itemCategoryId));

        return ResponseEntity.ok(category);
    }
}
