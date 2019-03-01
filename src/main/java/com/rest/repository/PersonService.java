package com.rest.repository;

import com.rest.model.person.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Optional<Person> findById(long id);

    List<Person> findAll();
}
