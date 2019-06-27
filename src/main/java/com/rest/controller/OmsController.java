package com.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Georgi Trendafilov
 */
@RestController
@RequestMapping("/efc/test/")
public class OmsController {

    private static final Logger log = LoggerFactory.getLogger(OmsController.class);

    @PostMapping(value = "/invoice")
    public ResponseEntity postInvoice(HttpEntity<String> data) {

        log.info("Received: {},", data.getBody());

        return ResponseEntity.ok().body("OK");
    }

}
