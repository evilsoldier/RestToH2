package com.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.person.Person;
import com.rest.repository.PersonRepository;
import com.rest.repository.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;

	@Override
	public Person findById(Long id) {
		return personRepository.findOne(id);
	}
}
