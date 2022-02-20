package com.gabrielone.personapi.service;

import com.gabrielone.personapi.entity.Person;
import com.gabrielone.personapi.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson( Person entity) {
        Person savePerson = personRepository.save(entity);
        return savePerson;
    }
}
