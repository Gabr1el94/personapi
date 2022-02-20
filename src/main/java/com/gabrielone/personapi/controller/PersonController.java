package com.gabrielone.personapi.controller;

import com.gabrielone.personapi.dto.MessageResponseDTO;
import com.gabrielone.personapi.entity.Person;
import com.gabrielone.personapi.repository.PersonRepository;
import com.gabrielone.personapi.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String home() {
        return "API Test!";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person entity) {
        Person savePerson = personService.createPerson(entity);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID"+ savePerson.getId())
                .build();
    }
    

}
