package com.rest.controller;

import com.rest.model.velocity.ItemInfo;
import com.rest.repository.ItemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/efc-iam-service/iam/")
public class ItemInfoController {


    private ItemInfoService service;

    @Autowired
    public ItemInfoController(ItemInfoService service) {
        this.service = service;
    }

    @GetMapping(value = "{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<ItemInfo> getItemInfo(@PathVariable(value = "itemId") Long itemId) {

        SecurityContextHolder.getContext().getAuthentication();
        return service.getItemInfoById(itemId);
    }
}
