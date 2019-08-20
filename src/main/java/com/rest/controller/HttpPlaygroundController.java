package com.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author Georgi Trendafilov
 * evilsoldier@abv.bg
 */
@RestController
@RequestMapping("/httpplayground")
public class HttpPlaygroundController {

    @GetMapping()
    @ResponseBody
    public ResponseEntity hello() {

        StringBuilder response = new StringBuilder();
        response.append("Play with HTTP.")
                .append(System.getProperty("line.separator"))
                .append("Send some data to /play")
                .append(System.getProperty("line.separator"))
                .append("with some parameters and see what will happens.")
                .append(System.getProperty("line.separator"))
                .append("It consumes JSON, so try to send some valid JSON objects :)");

        return ResponseEntity.ok(response.toString());
    }

    @PostMapping(value = "/play", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity play(RequestEntity requestEntity) {

        StringBuilder response = new StringBuilder();
        response.append("---------- HEADERS -----------")
                .append(System.getProperty("line.separator"));

        requestEntity.getHeaders()
                .forEach((key, value) -> response.append(key)
                        .append(" -> ")
                        .append(value)
                        .append(System.getProperty("line.separator")));
        response.append(System.getProperty("line.separator"));

        String[] queries = requestEntity.getUrl().getQuery().split("&");

        response.append("---------- QUERY -----------")
                .append(System.getProperty("line.separator"));

        Arrays.asList(queries).forEach(query -> response.append(query)
                .append(System.getProperty("line.separator")));

        response.append(System.getProperty("line.separator"));

        response.append("---------- BODY -----------")
                .append(System.getProperty("line.separator"));
        response.append(requestEntity.getBody());

        return ResponseEntity.ok(response.toString());
    }

}
