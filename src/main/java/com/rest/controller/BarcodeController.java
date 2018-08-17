package com.rest.controller;

import com.rest.model.barcode.KohlsBarcode;
import com.rest.model.barcode.Status;
import com.rest.model.barcode.StatusMessage;
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

    @RequestMapping(value = "/activateBarcode/{eventId}/{kcAmount}", method = RequestMethod.POST, produces = "application/json")
    public KohlsBarcode getBarcode(@PathVariable(value = "eventId") String eventId, @PathVariable(value = "kcAmount") Double kcAmount) {

        int pin = (int)(Math.random()*9000)+1000;
        KohlsBarcode barcode = new KohlsBarcode();
        barcode.setBarcode(eventId + pin + eventId);
        barcode.setPin(pin);
        //logger.info("generated barcode for " + eventId + " and kcAmoutn " + kcAmount);

        return barcode;
    }

    @RequestMapping(value = "/activateBarcode/testerror", method = RequestMethod.POST, produces = "application/json")
    public StatusMessage getBarcode() {

        StatusMessage statusMessage = new StatusMessage();
        Status status = new Status();
        status.setCode("ERROR");
        status.setMessage("ERROR Message");
        statusMessage.setStatus(status);

        return statusMessage;
    }
}
