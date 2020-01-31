package com.rest.controller;

import com.rest.model.oms.Error;
import com.rest.model.oms.MoreInfo;
import com.rest.model.oms.OmsResponse;
import com.rest.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

        log.info("Received: {}, {}", syncCount.incrementAndGet(), sync);

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
        log.info("Received: {}", JsonUtils.toJson(sync));

        // Sleep 100ms to simulate networking delay
        Thread.sleep(100L);
        return ResponseEntity.ok().body("OK");
    }

    @PostMapping(value = "/KOHLS_GIV_DSVProcessAvailableInventorySnapShot_exception", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postGivWithException(HttpEntity<String> data) {

        OmsResponse omsResponse = new OmsResponse();
        Error error = new Error();
        omsResponse.setErrors(new ArrayList() {{
            add(error);
        }});

        MoreInfo moreInfo = new MoreInfo();
        moreInfo.setErrorRelatedMoreInfo("Invalid Order");
        error.setMoreInfo(moreInfo);
        error.setErrorDescription("YFS:Invalid Order");
        error.setErrorUniqueExceptionId("10.218.7.12915628556059440000000003827");
        error.setErrorCode("YFS100066");
        error.setHttpcode(400);

        log.info("Received: {},", data.getBody());

        return ResponseEntity.badRequest().body(omsResponse);
    }
}
