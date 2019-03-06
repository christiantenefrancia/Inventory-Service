package com.inventoryservice.serviceImpl;

import com.inventoryservice.domain.ItemCategory;
import com.inventoryservice.repository.ItemCategoryRepository;
import com.inventoryservice.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ItemCategoryServiceImpl implements ItemCategoryService{

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public Iterable<ItemCategory> getItemCategories() {

        return itemCategoryRepository.findAll();
    }

    @Override
    public Optional<ItemCategory> getItemCategoryByItemCategoryId(Long itemCategoryId) {

        return itemCategoryRepository.findById(itemCategoryId);
    }

    @Override
    public ItemCategory save(ItemCategory itemCategory) {

        return itemCategoryRepository.save(itemCategory);
    }
}
