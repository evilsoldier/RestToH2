package com.rest.controller;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	@RequestMapping(value = "/efc-velocity-rest/{item_id}/{efc_id}", method = RequestMethod.GET, produces = "application/json")
	public Item getItem(@PathVariable(value = "item_id") String itemId, @PathVariable(value = "efc_id") String efcId) {
		List<Item> items = itemService.getAllItems();
		HashSet<Efc> efcs = new HashSet<>();

		for (Item item : items) {
			if (item.getItemId().equals(itemId)) {
				for (Efc efc : item.getEfcs()) {
					if (efc.getEfc().equals(efcId)) {
						efcs.add(efc);
						return new Item (itemId, efcs);
					}
				}
			}
		}
		return new Item(itemId, new HashSet<>());
	}

	// Read all efc/velocities by ItemId
	@RequestMapping(value = "/efc-velocity-rest/efcs/{item_id}", method = RequestMethod.GET, produces = "application/json")
	public Item getAllEfcs(@PathVariable(value = "item_id") String itemId) {
		List<Item> items = itemService.getAllItems();
		for (Item item : items) {
			if (item.getItemId().equals(itemId)) {
				return item;
			}
		}
		return new Item(itemId, new HashSet<>());
	}

	// Read all items from efc
	@RequestMapping(value = "/efc-velocity-rest/{efc_id}", method = RequestMethod.GET, produces = "application/json")
	public List<Item> getAllItems(@PathVariable(value = "efc_id") String efcId) {
		if ("EFC5".equalsIgnoreCase(efcId)) {
			return itemService.getAllItems();
		}
		return null;
	}

	// Delete EFC Details
	@RequestMapping(value = "/efc-velocity-rest/{item_id}/{efc_id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseMessage deleteItem(@PathVariable(value = "item_id") String itemId,
			@PathVariable(value = "efc_id") String efcId) {
		List<Item> items = itemService.getAllItems();

		for (Item item : items) {
			if (item.getItemId().equals(itemId)) {
				for (Efc efc : item.getEfcs()) {
					if (efc.getEfc().equals(efcId)) {
						item.getEfcs().remove(efc);
						System.out.println("Item Efc Velocity deleted: itemid: " + itemId + " efcid: " + efcId);
						itemService.updateItem(item);
						return new ResponseMessage("record deleted with itemId: " + itemId);
					}
				}
			}
		}
		return new ResponseMessage("record not found with itemId: " + itemId);
	}

	// Insert / Update EFC Details
	@RequestMapping(value = "/efc-velocity-rest/{item_id}/{efc_id}/{velocity}", method = RequestMethod.POST, produces = "application/json")
	public ResponseMessage updateItem(@PathVariable(value = "item_id") String itemId,
			@PathVariable(value = "efc_id") String efcId, @PathVariable(value = "velocity") String velocity) {
		List<Item> items = itemService.getAllItems();

		HashSet<Efc> efcs = new HashSet<>();

		Item item = new Item(itemId, efcs);

		for (Item i : items) {
			if (i.getItemId().equals(itemId)) {
				item = i;
				efcs = item.getEfcs();
				for (Efc efc : efcs) {
					if (efc.getEfc().equals(efcId)) {
						efc.setVelocity(velocity);
						item.setEfcs(efcs);
						itemService.updateItem(item);
						return new ResponseMessage(
								"updated/created item with itemId: " + item.getItemId() + " velocity: " + velocity);
					}
				}
				item.setEfcs(efcs);
			}
		}
		efcs.add(new Efc(efcId, velocity));
		item.setEfcs(efcs);
		itemService.updateItem(item);
		System.out.println("Updated/Created itemId: " + itemId);
		return new ResponseMessage("updated/created item with itemId: " + item.getItemId());
	}
}
