package com.rest.repository;

import java.util.List;

import com.rest.model.person.Person;

public interface PersonService {

	Person findById(Long id);
	
	List<Person> findAll();
	
}
