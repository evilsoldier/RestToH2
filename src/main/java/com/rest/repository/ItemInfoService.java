package com.rest.repository;

import com.rest.model.velocity.ItemInfo;

import java.util.Optional;

public interface ItemInfoService {
    Optional<ItemInfo> getItemInfoById(String itm_id);
}
