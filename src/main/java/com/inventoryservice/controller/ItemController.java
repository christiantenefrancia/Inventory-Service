package com.inventoryservice.controller;

import com.inventoryservice.exception.ResourceNotFoundException;
import com.inventoryservice.domain.Item;
import com.inventoryservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping
	public List<Item> findAll() {
		
		return StreamSupport.stream(itemService.getItems().spliterator(), false).collect(Collectors.toList());
	}
	
	@GetMapping("/{itemId}")
	public ResponseEntity<Item> findByItemId (@PathVariable Long itemId)
			throws ResourceNotFoundException {
		
		Item _item = itemService.getItemByItemId(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item category not found for this id :: " + itemId));

		return ResponseEntity.ok().body(_item);
	}
	
	@PostMapping
	public Item addItem(@RequestBody Item item){
		
		return itemService.save(item);
	}

	@PutMapping("/{itemId}")
	public ResponseEntity updateItem(@PathVariable Long itemId, @RequestBody Item item)
			throws ResourceNotFoundException {

		Item _item =  itemService.getItemByItemId(itemId)
				.map(s ->{
					itemService.save(item);
					return s;
				})
				.orElseThrow(() -> new ResourceNotFoundException("Item category not found for this id :: " + itemId));

		return ResponseEntity.ok(_item);
	}
}