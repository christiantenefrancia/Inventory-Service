package com.inventoryservice.service;

import com.inventoryservice.domain.ItemSubCategory;

import java.util.Optional;

public interface ItemSubCategoryService {

    public Iterable<ItemSubCategory> getItemSubCategories();

    public Optional<ItemSubCategory> getItemSubCategoryByItemSubCategoryId(Long ItemSubCategoryId);

    public ItemSubCategory save(ItemSubCategory itemSubCategory);

}
