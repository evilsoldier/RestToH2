package com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.person.Person;

@Repository("personRepository")
public interface PersonRepository extends JpaRepository<Person, Long>{

}
