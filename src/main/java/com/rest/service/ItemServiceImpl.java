package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.velocity.Item;
import com.rest.repository.ItemRepository;
import com.rest.repository.ItemService;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;

	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public void deleteItem(String itemId) {
		List<Item> allItems = itemRepository.findAll();
		for (Item item : allItems) {
			if (itemId.equals(item.getItemId())) {
				itemRepository.delete(item);
			}
		}
	}

	@Override
	public void updateItem(Item item) {
		itemRepository.save(item);
	}

	@Override
	public Item findById(String itemId) {
		return itemRepository.findOne(Long.valueOf(itemId));
	}
}
