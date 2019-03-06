package com.inventoryservice.repository;

import com.inventoryservice.domain.ItemCategory;
import org.springframework.data.repository.CrudRepository;

public interface ItemCategoryRepository extends CrudRepository<ItemCategory, Long> {
}
