package com.gabrielone.personapi.repository;

import com.gabrielone.personapi.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
