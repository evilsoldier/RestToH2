package com.rest.controller;

import com.rest.model.velocity.Efc;
import com.rest.model.velocity.Item;
import com.rest.repository.ItemService;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import response.ResponseMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

/**
 * @author Georgi Trendafilov
 * evilsoldier@abv.bg
 */
@RestController
@RequestMapping("/efc-velocity-service/velocity/")
public class ItemController {

    private final ItemService itemService;

    private static final String EFC_ID = "efc_id";

    private static final String ITEM_ID = "item_id";

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /**
     * Read efc details by given itemId and efcId.
     *
     * @param itemId
     * @param efcId
     * @return item instance of {@link Item}
     */
    @GetMapping(value = "/{item_id}/{efc_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Item getItem(@PathVariable(value = ITEM_ID) Long itemId, @PathVariable(value = EFC_ID) String efcId) {
        Optional<Item> optionalItem = itemService.findById(itemId);

        return optionalItem.orElseGet(() -> new Item(itemId, new HashSet<>()));
    }

    /**
     * Read all efc/velocities by given itemId.
     *
     * @param itemId
     * @return item instance of {@link Item}
     */
    @GetMapping(value = "/efcs/{item_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Item> getAllEfcs(@PathVariable(value = ITEM_ID) long itemId) {

        return itemService.findById(itemId);
    }

    /**
     * Read all items from efc by given efcId.
     *
     * @param efcId
     * @return listOf items instance of {@link Item}
     */
    @GetMapping(value = "/{efc_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getAllItems(@PathVariable(value = EFC_ID) String efcId) {
        if ("839".equalsIgnoreCase(efcId)) {
            return itemService.getAllItems();
        }
        return new ArrayList<>();
    }

    /**
     * Delete efc details by given itemId and efcId.
     *
     * @param itemId
     * @param efcId
     * @return httpStatus instance of {@link HttpStatus}
     */
    @DeleteMapping(value = "/{item_id}/{efc_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage deleteItem(@PathVariable(value = ITEM_ID) String itemId,
                                      @PathVariable(value = EFC_ID) String efcId) {
        List<Item> items = itemService.getAllItems();

        for (Item item : items) {
            if (item.getItemId().toString().equalsIgnoreCase(itemId)) {
                for (Efc efc : item.getEfcs()) {
                    if (efc.getEfc().equals(efcId)) {
                        item.getEfcs().remove(efc);
                        logger.info("Item Efc Velocity deleted: itemid: {} efcid: {}", itemId, efcId);
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
     *
     * @param itemId
     * @param efcId
     * @param velocity
     * @return httpStatus instance of {@link HttpStatus}
     */
    @PostMapping(value = "/{item_id}/{efc_id}/{velocity}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage updateItem(@PathVariable(value = ITEM_ID) Long itemId,
                                      @PathVariable(value = EFC_ID) String efcId, @PathVariable(value = "velocity") String velocity) {
        List<Item> items = itemService.getAllItems();

        HashSet<Efc> efcs = new HashSet<>();

        Item item = new Item(itemId, efcs);

        for (Item i : items) {
            if (i.getItemId().toString().equalsIgnoreCase(itemId.toString())) {
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
        logger.info("Updated/Created itemId: {}", itemId);
        return new ResponseMessage("updated/created item with itemId: " + item.getItemId());
    }

    @GetMapping(value = "/{item_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Item> findItemById(@PathVariable(value = ITEM_ID) long itemId) {
        return itemService.findById(itemId);
    }
}
