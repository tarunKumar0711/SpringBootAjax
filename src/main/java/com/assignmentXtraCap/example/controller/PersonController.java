package com.assignmentXtraCap.example.controller;

import com.assignmentXtraCap.example.Repository.PersonRepository;
import com.assignmentXtraCap.example.dtos.PersonDto;
import com.assignmentXtraCap.example.mapper.PersonMapper;
import com.assignmentXtraCap.example.model.Person;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @PostMapping("/add")
    public ResponseEntity<?> addPerson(@Valid @RequestBody PersonDto personDto) {
        try{
            Person newPerson = PersonMapper.mapToPerson(personDto);
            personRepository.save(newPerson);
            return new ResponseEntity<Person>(newPerson, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/persons")
    @ResponseBody
    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    }
}