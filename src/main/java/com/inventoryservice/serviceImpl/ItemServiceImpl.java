package com.inventoryservice.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventoryservice.domain.Item;
import com.inventoryservice.repository.ItemRepository;
import com.inventoryservice.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Iterable<Item> getItems() {
		
		return itemRepository.findAll();
	}

	@Override
	public Optional<Item> getItemByItemId(Long itemId) {
		
		return itemRepository.findById(itemId);
	}

	@Override
	public Item save(Item item) {
		
		return itemRepository.save(item);
	}

}
