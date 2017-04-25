package com.rest.repository;

import java.util.List;
import com.rest.velocity.Item;

public interface ItemService {
	List<Item> getAllItems();
	
	void deleteItem(String itemId);
	
	void updateItem(Item item);
}
