package com.inventoryservice.serviceImpl;

import com.inventoryservice.domain.ItemSubCategory;
import com.inventoryservice.repository.ItemSubCategoryRepository;
import com.inventoryservice.service.ItemSubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ItemSubCategoryServiceImpl implements ItemSubCategoryService{

    @Autowired
    private ItemSubCategoryRepository itemSubCategoryRepository;

    @Override
    public Iterable<ItemSubCategory> getItemSubCategories() {

        return itemSubCategoryRepository.findAll();
    }

    @Override
    public Optional<ItemSubCategory> getItemSubCategoryByItemSubCategoryId(Long itemSubCategoryId) {

        return itemSubCategoryRepository.findById(itemSubCategoryId);
    }

    @Override
    public ItemSubCategory save(ItemSubCategory itemSubCategory) {

        return itemSubCategoryRepository.save(itemSubCategory);
    }
}
