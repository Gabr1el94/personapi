package com.gabrielone.personapi.controller;

import com.gabrielone.personapi.dto.MessageResponseDTO;
import com.gabrielone.personapi.entity.Person;
import com.gabrielone.personapi.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;
    
    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public String home() {
        return "API Test!";
    }

    @PostMapping(value="path")
    public MessageResponseDTO createPerson(@RequestBody Person entity) {
        Person savePerson = personRepository.save(entity);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID"+ savePerson.getId())
                .build();
    }
    

}
