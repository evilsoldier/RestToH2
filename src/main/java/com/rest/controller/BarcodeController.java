package com.rest.controller;

import com.rest.model.barcode.KohlsBarcode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BarcodeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @RequestMapping(value = "/barcode/{email}", method = RequestMethod.GET, produces = "application/json")
    public KohlsBarcode getBarcode(@PathVariable(value = "email") String email) {

        KohlsBarcode barcode = new KohlsBarcode();
        barcode.setMail(email);
        barcode.setBarcode(String.valueOf(email.hashCode()));
        //logger.info("generated barcode for " + email);
        return barcode;
    }
}
