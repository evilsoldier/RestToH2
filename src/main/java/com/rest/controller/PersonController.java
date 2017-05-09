package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rest.repository.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("/person")
	public String welcome(Model model, @RequestParam(value="id", defaultValue="1") Long id) {
		model.addAttribute("person", personService.findById(id));
		return "person";
	}
}
