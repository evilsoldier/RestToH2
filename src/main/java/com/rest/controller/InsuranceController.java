package com.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author Georgi Trendafilov
 */
@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    private static final Logger log = LoggerFactory.getLogger(InsuranceController.class);

    private final Random random = new Random();

    @PostMapping(value = "/getinsurance", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postGiv(@RequestBody String sync) throws InterruptedException {

        log.info("Received: {}", sync);

        // Sleep 100ms to simulate networking delay

        Thread.sleep(100L);
        return ResponseEntity.ok().body(random.nextInt(1000000));
    }
}
