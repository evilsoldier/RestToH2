package com.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.velocity.ItemInfo;
import com.rest.repository.ItemInfoService;

@RestController
@RequestMapping("/")
public class ItemInfoController {

	@Autowired
	ItemInfoService service;

	@RequestMapping(value = "/efc-iam-rest/{itm_id}", method = RequestMethod.GET, produces = "application/json")
	public ItemInfo getItemInfo(@PathVariable(value = "itm_id") String itm_id, HttpServletRequest request) {
		
		SecurityContextHolder.getContext().getAuthentication();
		ItemInfo itemInfo = service.getItemInfoById(itm_id);
		
		return itemInfo != null ? itemInfo : null;
	}
}
