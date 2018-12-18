package com.rest.repository;

import java.util.List;
import java.util.Optional;

import com.rest.model.person.Person;

public interface PersonService {

    Optional<Person> findById(long id);

    List<Person> findAll();

}
