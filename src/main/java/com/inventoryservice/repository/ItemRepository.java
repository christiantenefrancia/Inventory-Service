package com.inventoryservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventoryservice.domain.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{

}
