package com.rest.repository;

import com.rest.model.velocity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<Item> getAllItems();

    void deleteItem(Item itemId);

    void updateItem(Item item);

    Optional<Item> findById(long itemId);
}
