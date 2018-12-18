package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.velocity.Item;
import com.rest.repository.ItemRepository;
import com.rest.repository.ItemService;

import javax.swing.text.html.Option;

@Service("itemService")
public class ItemServiceImpl implements ItemService {


    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> findById(long itemId) {
        return itemRepository.findById(itemId);
    }

    @Override
    public void deleteItem(Item item) {
        itemRepository.delete(item);
    }

    @Override
    public void updateItem(Item item) {
        itemRepository.save(item);
    }

}
