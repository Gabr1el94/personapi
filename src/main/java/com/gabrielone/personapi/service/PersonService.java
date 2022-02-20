package com.gabrielone.personapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.gabrielone.personapi.dto.request.PersonDTO;
import com.gabrielone.personapi.entity.Person;
import com.gabrielone.personapi.exception.PersonNotFoundException;
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

    public List<PersonDTO> listAll() {
        List<Person> peoples= personRepository.findAll();
        return peoples.stream().map(personMapper::toDTO)
        .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            throw new PersonNotFoundException(id);
        }
        return personMapper.toDTO(personOptional.get());
    }
}
