package com.gabrielone.personapi.service;

import com.gabrielone.personapi.dto.request.PersonDTO;
import com.gabrielone.personapi.entity.Person;
import com.gabrielone.personapi.mapper.PersonMapper;
import com.gabrielone.personapi.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(PersonDTO entity) {
        Person personToSave = personMapper.toModel(entity);

        Person savePerson = personRepository.save(personToSave );
        return savePerson;
    }
}
