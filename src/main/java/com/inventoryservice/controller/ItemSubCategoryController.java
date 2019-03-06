package com.inventoryservice.controller;

import com.inventoryservice.exception.ResourceNotFoundException;
import com.inventoryservice.domain.ItemSubCategory;
import com.inventoryservice.service.ItemSubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/subCategories")
public class ItemSubCategoryController {

    @Autowired
    private ItemSubCategoryService itemSubCategoryService;

    @GetMapping
    public List<ItemSubCategory> findAll() {

        return StreamSupport.stream(itemSubCategoryService.getItemSubCategories().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/{itemSubCategoryId}")
    public ResponseEntity<ItemSubCategory> findByItemSubCategoryId (@PathVariable Long itemSubCategoryId)
            throws ResourceNotFoundException {

        ItemSubCategory itemSubCategory = itemSubCategoryService.getItemSubCategoryByItemSubCategoryId(itemSubCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Item category not found for this id :: " + itemSubCategoryId));

        return ResponseEntity.ok().body(itemSubCategory);

    }

    @PostMapping
    public ItemSubCategory addItemSubCategory(@RequestBody ItemSubCategory itemSubCategory){

        return itemSubCategoryService.save(itemSubCategory);
    }

    @PutMapping("/{itemSubCategoryId}")
    public ResponseEntity updateItemSubCategory(@PathVariable Long itemSubCategoryId, @RequestBody ItemSubCategory itemSubCategory)
            throws ResourceNotFoundException {

        ItemSubCategory subCategory = itemSubCategoryService.getItemSubCategoryByItemSubCategoryId(itemSubCategoryId)
                .map(s -> {
                    itemSubCategoryService.save(itemSubCategory);
                    return s;
                })
                .orElseThrow(() -> new ResourceNotFoundException("Item category not found for this id :: " + itemSubCategoryId));

        return ResponseEntity.ok(subCategory);
    }
}
