package com.inventoryservice.service;

import com.inventoryservice.domain.Item;

import java.util.Optional;

public interface ItemService {
	
	public Iterable<Item> getItems();
	
	public Optional<Item> getItemByItemId(Long itemId);
	
	public Item save(Item item);

}
