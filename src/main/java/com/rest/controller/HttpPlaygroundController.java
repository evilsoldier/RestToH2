package com.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Georgi Trendafilov
 * evilsoldier@abv.bg
 */
@RestController
@RequestMapping("/httpplayground")
public class HttpPlaygroundController {

    private Map<String, String> records = new HashMap<>();

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
                .append("It consumes JSON, so try to send some valid JSON objects :) ")
        .append("Try to send some query parameters with PUT and take a look at the response body. They should be returned in JSON manner. " +
                "Try to send some query parameters with DELETE and take a look at the response again. If one of the parameters is the same as which you have sent it should be missing in the response :) ");

        return ResponseEntity.ok(response.toString());
    }

    @PostMapping(value = "/play", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity play(RequestEntity request) {

        StringBuilder response = new StringBuilder();
        response.append("---------- HEADERS -----------")
                .append(System.getProperty("line.separator"));

        request.getHeaders()
                .forEach((key, value) -> response.append(key)
                        .append(" -> ")
                        .append(value)
                        .append(System.getProperty("line.separator")));
        response.append(System.getProperty("line.separator"));

        String[] queries;
        if (request.getUrl().getQuery() != null) {
            queries = request.getUrl().getQuery().split("&");

            response.append("---------- QUERY -----------")
                    .append(System.getProperty("line.separator"));

            Arrays.asList(queries).forEach(query -> response.append(query)
                    .append(System.getProperty("line.separator")));

            response.append(System.getProperty("line.separator"));
        }

        response.append("---------- BODY -----------")
                .append(System.getProperty("line.separator"));
        response.append(request.getBody());

        return ResponseEntity.ok(response.toString());
    }

    @PutMapping(value = "/play", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity put(RequestEntity request) {

        if (request.getUrl().getQuery() != null) {
            String[] queries = request.getUrl().getQuery().split("&");
            Arrays.asList(queries)
                    .forEach(query -> {
                        records.put(query.substring(0, query.indexOf("=")), query.substring(query.indexOf("=") +1));
                    });
        }

        return ResponseEntity.ok(records);
    }

    @DeleteMapping(value = "/play", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(RequestEntity request) {
        if (request.getUrl().getQuery() != null) {
            String[] queries = request.getUrl().getQuery().split("&");
            Arrays.asList(queries)
                    .forEach(query -> {
                        records.remove(query.substring(0, query.indexOf("=")));
                    });
        }

        return ResponseEntity.ok(records);
    }
}
