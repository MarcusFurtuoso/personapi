package com.projectapi.personapi.services;

import java.util.List;
import java.util.stream.Collectors;

import com.projectapi.personapi.dto.mapper.PersonMapper;
import com.projectapi.personapi.dto.request.PersonDTO;
import com.projectapi.personapi.dto.response.MessageResponseDTO;
import com.projectapi.personapi.entities.Person;
import com.projectapi.personapi.exception.PersonNotFoundException;
import com.projectapi.personapi.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor =  @__(@Autowired))
public class PersonService {
    
    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    public MessageResponseDTO create(PersonDTO personDTO) {

        Person person = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(person);

        MessageResponseDTO messageResponseDTO = createMessageResponse("Person successfully created with ID ", savedPerson.getId());

        return messageResponseDTO;
    }

    public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        personRepository.findById(id)
            .orElseThrow(() -> new PersonNotFoundException(id));
    
        Person updtadePerson = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(updtadePerson);
            
        MessageResponseDTO messageResponseDTO = createMessageResponse("Person successfully update with ID ", savedPerson.getId());

        return messageResponseDTO;
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDTO(person);
    }

    public List<PersonDTO> listAll() {
        List<Person> people = personRepository.findAll();
        return people.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void delete(Long id) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        personRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }
}