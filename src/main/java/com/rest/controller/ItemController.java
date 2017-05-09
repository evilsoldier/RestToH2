package com.rest.controller;

import java.util.HashSet;
import java.util.List;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.velocity.Efc;
import com.rest.model.velocity.Item;
import com.rest.repository.ItemService;

import response.ResponseMessage;

/**
 * @author Georgi Trendafilov
 * evilsoldier@abv.bg
 */
@RestController
@RequestMapping("/")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * Read efc details by given itemId and efcId.
	 * @param itemId
	 * @param efcId
	 * @return item instance of {@link Item}
	 */
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

	/**
	 * Read all efc/velocities by given itemId.
	 * @param itemId
	 * @return item instance of {@link Item}
	 */
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

	/**
	 * Read all items from efc by given efcId.
	 * @param efcId
	 * @return listOf items instance of {@link Item}
	 */
	@RequestMapping(value = "/efc-velocity-rest/{efc_id}", method = RequestMethod.GET, produces = "application/json")
	public List<Item> getAllItems(@PathVariable(value = "efc_id") String efcId) {
		if ("EFC5".equalsIgnoreCase(efcId)) {
			return itemService.getAllItems();
		}
		return null;
	}

	/**
	 * Delete efc details by given itemId and efcId.
	 * @param itemId
	 * @param efcId
	 * @return httpStatus instance of {@link HttpStatus}
	 */
	@RequestMapping(value = "/efc-velocity-rest/{item_id}/{efc_id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseMessage deleteItem(@PathVariable(value = "item_id") String itemId,
			@PathVariable(value = "efc_id") String efcId) {
		List<Item> items = itemService.getAllItems();

		for (Item item : items) {
			if (item.getItemId().equals(itemId)) {
				for (Efc efc : item.getEfcs()) {
					if (efc.getEfc().equals(efcId)) {
						item.getEfcs().remove(efc);
						logger.info("Item Efc Velocity deleted: itemid: " + itemId + " efcid: " + efcId);
						itemService.updateItem(item);
						return new ResponseMessage("record deleted with itemId: " + itemId);
					}
				}
			}
		}
		return new ResponseMessage("record not found with itemId: " + itemId);
	}

	/**
	 * Insert or Update efc Details by given itemId, efcId and velocity value.
	 * @param itemId
	 * @param efcId
	 * @param velocity
	 * @return httpStatus instance of {@link HttpStatus}
	 */
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
		logger.info("Updated/Created itemId: " + itemId);
		return new ResponseMessage("updated/created item with itemId: " + item.getItemId());
	}
	
	@RequestMapping(value = "/efc-velocity-rest/items/{itemId}", method = RequestMethod.GET, produces = "application/json")
	public Item findItemById(@PathVariable(value = "itemId") String itemId) {
		return itemService.findById(itemId);
	}
}
