package com.example.demo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;

@RestController
@RequestMapping("/api/persons")
public class PersonRestController {
    
    private final PersonRepository personRepository;
    
    public PersonRestController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping()
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        return ResponseEntity.ok(personRepository.save(person));
    }
    
    @GetMapping()
    public ResponseEntity<List<Person>> getAllPerson() {
        return ResponseEntity.ok(personRepository.findAll());
    }
    
    @GetMapping("/find-by-pesel")
    public ResponseEntity<List<Person>> findPersonByPesel(@RequestParam String pesel) {
        return ResponseEntity.ok(personRepository.findByPesel(pesel));
    }
    
}
