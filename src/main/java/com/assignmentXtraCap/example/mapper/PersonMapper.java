package com.assignmentXtraCap.example.mapper;

import com.assignmentXtraCap.example.dtos.PersonDto;
import com.assignmentXtraCap.example.model.Person;

public class PersonMapper {

    public static PersonDto mapToPersonDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setEmail(person.getEmail());
        personDto.setName(person.getName());
        personDto.setMobileNumber(person.getMobileNumber());
        personDto.setFathersName(person.getFathersName());
        personDto.setPanNumber(person.getPanNumber());
        return personDto;
    }

    public static Person mapToPerson(PersonDto personDto) {
        Person person = new Person();
        person.setEmail(personDto.getEmail());
        person.setName(personDto.getName());
        person.setMobileNumber(personDto.getMobileNumber());
        person.setFathersName(personDto.getFathersName());
        person.setPanNumber(personDto.getPanNumber());
        return person;
    }
}
