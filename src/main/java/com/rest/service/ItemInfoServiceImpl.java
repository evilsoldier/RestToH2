package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.velocity.ItemInfo;
import com.rest.repository.ItemInfoRepository;
import com.rest.repository.ItemInfoService;

@Service("itemInfoService")
public class ItemInfoServiceImpl implements ItemInfoService {

	@Autowired
	ItemInfoRepository repository;

	@Override
	public ItemInfo getItemInfoById(String itm_id) {
		List<ItemInfo> allItemInfos = repository.findAll();

		for (ItemInfo itemInfo : allItemInfos) {
			if (itemInfo.getItemID().equals(itm_id)) {
				return itemInfo;
			}
		}
		return null;
	}
}
