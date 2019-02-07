package com.rest.controller;

import com.rest.model.velocity.ItemInfo;
import com.rest.repository.ItemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class ItemInfoController {


    private ItemInfoService service;

    @Autowired
    public ItemInfoController(ItemInfoService service) {
        this.service = service;
    }

    @GetMapping(value = "/efc-iam-rest/{itm_id}", produces = "application/json")
    public ItemInfo getItemInfo(@PathVariable(value = "itm_id") String itm_id, HttpServletRequest request) {

        SecurityContextHolder.getContext().getAuthentication();
        return service.getItemInfoById(itm_id);
    }
}
