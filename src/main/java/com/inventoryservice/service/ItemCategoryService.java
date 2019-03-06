package com.inventoryservice.service;

import com.inventoryservice.domain.ItemCategory;

import java.util.Optional;

public interface ItemCategoryService {

    public Iterable<ItemCategory> getItemCategories();

    public Optional<ItemCategory> getItemCategoryByItemCategoryId(Long ItemCategoryId);

    public ItemCategory save(ItemCategory itemCategory);
}
