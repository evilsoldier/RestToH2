package com.rest.controller;

import com.rest.model.barcode.KohlsBarcodeRequest;
import com.rest.model.barcode.KohlsBarcodeResponse;
import com.rest.model.barcode.Status;
import com.rest.model.barcode.StatusMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BarcodeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @RequestMapping(value = "/activateBarcode/", method = RequestMethod.POST, produces = "application/json")
    public KohlsBarcodeResponse getBarcode(@RequestBody KohlsBarcodeRequest request) {

        int pin = (int)(Math.random()*9000)+1000;
        KohlsBarcodeResponse barcode = new KohlsBarcodeResponse();
        barcode.setBarcode(request.getEventId() + pin + request.getEventId());
        barcode.setPin(pin);
       // logger.info("generated barcode for " + request.getEventId() + " and kcAmoutn " + request.getEventId());

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

    @RequestMapping(value = "/postMessage", method = RequestMethod.POST, produces = "application/json")
    public String postMessage(@RequestBody String message) {

        logger.info(message);

        return message;
    }
}
