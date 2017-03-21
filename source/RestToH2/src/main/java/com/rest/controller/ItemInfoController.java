package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.repository.ItemInfoService;
import com.rest.velocity.ItemInfo;

@RestController
@RequestMapping("/efc/iteminfo")
public class ItemInfoController {

	@Autowired
	ItemInfoService service;

	@RequestMapping(value = "/{itm_id}", method = RequestMethod.GET, produces = "application/json")
	public ItemInfo getItemInfo(@PathVariable(value = "itm_id") String itm_id) {
		
		ItemInfo itemInfo = service.getItemInfoById(itm_id);
		
		return itemInfo != null ? itemInfo : null;
	}
}
