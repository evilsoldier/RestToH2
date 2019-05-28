package com.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Georgi Trendafilov
 * evilsoldier@abv.bg
 */
@RestController
@RequestMapping("/smcfs/restapi/executeFlow/")
public class GivController {

    private static final Logger log = LoggerFactory.getLogger(GivController.class);

    @PostMapping(value = "/KOHLS_GIV_DSVProcessAvailableInventorySnapShot_Sync", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postGiv(@RequestBody String sync) {
        log.info("Received: {}", sync);

        return ResponseEntity.ok().body("OK");
    }

    @PostMapping(value = "/KohlsProcessShipConfirmCancelSyncRestService", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postOms(@RequestBody String sync) {
        log.info("Received: {}", sync);

        return ResponseEntity.ok().body("OK");
    }
}
