package com.rest.controller;

import com.rest.model.oms.Error;
import com.rest.model.oms.OmsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Georgi Trendafilov
 */
@RestController
@RequestMapping("/efc/test/")
public class OmsController {

    private static final Logger log = LoggerFactory.getLogger(OmsController.class);

    @PostMapping(value = "/invoice", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postInvoice(HttpEntity<String> data) {
        OmsResponse omsResponse = new OmsResponse();
        Error error = new Error();
        omsResponse.setErrors(new ArrayList() {{
            add(error);
        }});

        error.setErrorDescription("YFS:Invalid Order");
        error.setErrorUniqueExceptionId("10.218.7.12915628556059440000000003827");
        error.setErrorCode("YFS10003");
        error.setHttpcode(400);

        log.info("Received: {},", data.getBody());

        //return ResponseEntity.badRequest().body(omsResponse);
        return ResponseEntity.ok().body("OK");
    }

}
