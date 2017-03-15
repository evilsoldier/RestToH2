package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.repository.ItemService;
import com.rest.velocity.Item;

@RestController
@RequestMapping("/efc")
public class ItemController {

	@Autowired
	ItemService itemService;

	@RequestMapping(value = "/{item_id}/{efc_id}", method = RequestMethod.GET)
	public Item getEmployee(@PathVariable(value = "item_id") String itemId,
			@PathVariable(value = "efc_id") String efcId) {
		List<Item> items = itemService.getAllItems();

		for (Item item : items) {
			if (item.getItemId().equals(itemId) && "EFC5".equalsIgnoreCase(efcId)) {
				return item;
			}
		}
		return null;
	}
}
