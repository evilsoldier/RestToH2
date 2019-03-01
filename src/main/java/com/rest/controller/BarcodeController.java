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

    @PostMapping(value = "/activateBarcode/", produces = "application/json")
    public KohlsBarcodeResponse getBarcode(@RequestBody KohlsBarcodeRequest request) {

        int pin = (int) (Math.random() * 9000) + 1000;
        KohlsBarcodeResponse barcode = new KohlsBarcodeResponse();
        barcode.setBarcode(request.getEventId() + pin + request.getEventId());
        barcode.setPin(pin);
        // logger.info("generated barcode for " + request.getEventId() + " and kcAmoutn " + request.getEventId());

        return barcode;
    }

    @PostMapping(value = "/activateBarcode/testerror", produces = "application/json")
    public StatusMessage getBarcode() {

        StatusMessage statusMessage = new StatusMessage();
        Status status = new Status();
        status.setCode("ERROR");
        status.setMessage("ERROR Message");
        statusMessage.setStatus(status);

        return statusMessage;
    }

    @PostMapping(value = "/postMessage")
    public String postMessage(@RequestBody String message) {

        logger.info(message);

        return message;
    }
}
