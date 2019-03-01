package com.rest.service;

import com.rest.model.velocity.ItemInfo;
import com.rest.repository.ItemInfoRepository;
import com.rest.repository.ItemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("itemInfoService")
public class ItemInfoServiceImpl implements ItemInfoService {


    private final ItemInfoRepository repository;

    @Autowired
    public ItemInfoServiceImpl(ItemInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ItemInfo> getItemInfoById(Long itm_id) {
        return repository.findById(itm_id);
    }
}
