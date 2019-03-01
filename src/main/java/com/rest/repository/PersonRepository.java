package com.rest.repository;

import com.rest.model.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("personRepository")
public interface PersonRepository extends JpaRepository<Person, Long> {
}
