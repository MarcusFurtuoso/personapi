package com.projectapi.personapi.repositories;

import com.projectapi.personapi.entities.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
