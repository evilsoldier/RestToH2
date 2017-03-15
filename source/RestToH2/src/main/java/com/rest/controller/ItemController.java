package com.rest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.repository.ItemService;
import com.rest.velocity.Item;

import response.ResponseMessage;

@RestController
@RequestMapping("/efc")
public class ItemController {

	@Autowired
	ItemService itemService;

	// Read EFC Details by Item ID and EFC ID
	@RequestMapping(value = "/{item_id}/{efc_id}", method = RequestMethod.GET, produces = "application/json")
	public Item getItem(@PathVariable(value = "item_id") String itemId, @PathVariable(value = "efc_id") String efcId) {
		List<Item> items = itemService.getAllItems();

		for (Item item : items) {
			if (item.getItemId().equals(itemId) && "EFC5".equalsIgnoreCase(efcId)) {
				return item;
			}
		}
		return null;
	}

	// Read all items from efc
	@RequestMapping(value = "/velocity/{efc_id}", method = RequestMethod.GET, produces = "application/json")
	public List<Item> getAllItems(@PathVariable(value = "efc_id") String efcId) {
		if ("EFC5".equalsIgnoreCase(efcId)) {
			return itemService.getAllItems();
		}
		return null;
	}

	// Delete EFC Details
	@RequestMapping(value = "/velocity/{item_id}/{efc_id}", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	public ResponseMessage deleteItem(@RequestBody String json, @PathVariable(value = "item_id") String itemId,
			@PathVariable(value = "efc_id") String efcId) {
		List<Item> items = itemService.getAllItems();

		for (Item item : items) {
			if (item.getItemId().equals(itemId) && "EFC5".equalsIgnoreCase(efcId)) {
				itemService.deleteItem(itemId);
				return new ResponseMessage("record deleted with itemId: " + itemId);
			}
		}
		return new ResponseMessage("record not found with itemId: " + itemId);
	}

	// Insert / Update EFC Details
	@RequestMapping(value = "/velocity/{item_id}/{efc_id}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseMessage updateItem(@PathVariable(value = "item_id") String itemId,
			@PathVariable(value = "efc_id") String efcId, @RequestBody String json) {
		Item item = new Item();
		ObjectMapper mapper = new ObjectMapper();
		try {
			item = mapper.readValue(json, Item.class);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		itemService.updateItem(item);
		return new ResponseMessage("updated/created item with itemId: " + item.getItemId());
	}
}
