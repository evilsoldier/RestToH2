package com.rest.repository;

import com.rest.model.person.Person;

public interface PersonService {

	Person findById(Long id);
	
}
