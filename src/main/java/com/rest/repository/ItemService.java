package com.rest.repository;

import java.util.List;

import com.rest.model.velocity.Item;

public interface ItemService {
	List<Item> getAllItems();
	
	void deleteItem(String itemId);
	
	void updateItem(Item item);
	
	Item findById(String itemId);
}
