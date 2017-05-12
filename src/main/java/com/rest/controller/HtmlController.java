package com.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HtmlController {

	@GetMapping("/")
	public String mainController() {
		return "Hello, seems like your application is running :)";
	}

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}
}
