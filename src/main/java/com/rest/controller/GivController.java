package com.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Georgi Trendafilov
 * evilsoldier@abv.bg
 */
@RestController
@RequestMapping("/smcfs/restapi/executeFlow/")
public class GivController {

    private static final Logger log = LoggerFactory.getLogger(GivController.class);

    private AtomicLong syncCount = new AtomicLong(0L);

    @PostMapping(value = "/KOHLS_GIV_DSVProcessAvailableInventorySnapShot_Sync", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postGiv(@RequestBody String sync) throws InterruptedException {
        syncCount.incrementAndGet();
        log.info("Received: {}", syncCount.get(), sync);

        // Sleep 100ms to simulate networking delay

        Thread.sleep(100L);
        return ResponseEntity.ok().body("OK");
    }

    @GetMapping(value = "/reset", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity resetCount() {
        log.info("Reset counter");
        syncCount = new AtomicLong(0L);
        return ResponseEntity.ok().body("OK");
    }

    @PostMapping(value = "/KohlsProcessShipConfirmCancelSyncRestService", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postOms(@RequestBody String sync) throws InterruptedException {
        log.info("Received: {}", sync);

        // Sleep 100ms to simulate networking delay
        Thread.sleep(100L);
        return ResponseEntity.ok().body("OK");
    }
}
