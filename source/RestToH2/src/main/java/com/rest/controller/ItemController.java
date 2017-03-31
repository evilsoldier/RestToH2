package com.rest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.repository.ItemService;
import com.rest.velocity.Efc;
import com.rest.velocity.Item;

import response.ResponseMessage;

@RestController
@RequestMapping("/")
public class ItemController {

	@Autowired
	ItemService itemService;

	// Read EFC Details by Item ID and EFC ID
	@RequestMapping(value = "/efc-rest/velocity/{item_id}/{efc_id}", method = RequestMethod.GET, produces = "application/json")
	public Item getItem(@PathVariable(value = "item_id") String itemId, @PathVariable(value = "efc_id") String efcId) {
		List<Item> items = itemService.getAllItems();

		for (Item item : items) {
			if (item.getItemId().equals(itemId)) {
				return item;
			}
		}
		return new Item(itemId, new ArrayList<>());
	}

	// Read all items from efc
	@RequestMapping(value = "/efc-rest/velocity/{efc_id}", method = RequestMethod.GET, produces = "application/json")
	public List<Item> getAllItems(@PathVariable(value = "efc_id") String efcId) {
		if ("EFC5".equalsIgnoreCase(efcId)) {
			return itemService.getAllItems();
		}
		return null;
	}

	// Delete EFC Details
	@RequestMapping(value = "/efc-rest/velocity/{item_id}/{efc_id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseMessage deleteItem(@PathVariable(value = "item_id") String itemId,
			@PathVariable(value = "efc_id") String efcId) {
		List<Item> items = itemService.getAllItems();

		for (Item item : items) {
			if (item.getItemId().equals(itemId)) {
				System.out.println("Deletede itemId: " + itemId);
				itemService.deleteItem(itemId);
				return new ResponseMessage("record deleted with itemId: " + itemId);
			}
		}
		return new ResponseMessage("record not found with itemId: " + itemId);
	}

	// Insert / Update EFC Details
	@RequestMapping(value = "/efc-rest/velocity/{item_id}/{efc_id}/{velocity}", method = RequestMethod.POST, produces = "application/json")
	public ResponseMessage updateItem(@PathVariable(value = "item_id") String itemId,
			@PathVariable(value = "efc_id") String efcId, @PathVariable(value = "velocity") String velocity) {
		ArrayList<Efc> efcs = new ArrayList<>();
		efcs.add(new Efc(efcId, velocity));
		Item item = new Item(itemId, efcs);

		// ObjectMapper mapper = new ObjectMapper();
		// try {
		// item = mapper.readValue(json, Item.class);
		// } catch (IOException e) {
		// System.out.println(e.getMessage());
		// }
		itemService.updateItem(item);
		System.out.println("Updated/Created itemId: " + itemId);
		return new ResponseMessage("updated/created item with itemId: " + item.getItemId());
	}
}
