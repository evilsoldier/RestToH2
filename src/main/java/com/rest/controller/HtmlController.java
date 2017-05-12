package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rest.repository.PersonService;

@Controller
public class HtmlController {

	@Autowired
	PersonService personService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}

	@GetMapping("/person")
	public String welcome(Model model, @RequestParam(value = "id", defaultValue = "1") Long id) {
		model.addAttribute("person", personService.findById(id));
		return "person";
	}

	@RequestMapping(value = "/ping", method = RequestMethod.GET, produces = "application/json")
	public String ping() {
		return "pong";
	}
}
