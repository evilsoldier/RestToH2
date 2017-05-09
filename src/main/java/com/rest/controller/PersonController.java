package com.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.person.Person;
import com.rest.repository.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	PersonService personService;

	@RequestMapping(value = "/{personId}", method = RequestMethod.GET, produces = "application/json")
	public Person getItemInfo(@PathVariable(value = "personId") Long personId, HttpServletRequest request) {

		return personService.findById(personId);
	}
}
