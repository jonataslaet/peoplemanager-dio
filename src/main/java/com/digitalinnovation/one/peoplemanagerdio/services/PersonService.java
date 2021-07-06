package com.digitalinnovation.one.peoplemanagerdio.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.digitalinnovation.one.peoplemanagerdio.controllers.dtos.PersonDTO;
import com.digitalinnovation.one.peoplemanagerdio.domain.Person;
import com.digitalinnovation.one.peoplemanagerdio.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public ResponseEntity<PersonDTO> insert(PersonDTO person) {
		
		Person savedPerson = personRepository.save(new Person(person));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPerson.getId())
				.toUri();

		return ResponseEntity.created(uri).body(new PersonDTO(savedPerson));
	}

	public ResponseEntity<PersonDTO> findById(Long id) {
		Person foundPerson = findOneById(id);
		if (foundPerson == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new PersonDTO(foundPerson));
	}

	private Person findOneById(Long id) {
		Optional<Person> foundPerson = personRepository.findById(id);

		if (!foundPerson.isPresent()) {
			return null;
		}

		return foundPerson.get();
	}

	public ResponseEntity<List<PersonDTO>> findAll() {
		List<Person> allPeople = personRepository.findAll();
		return ResponseEntity.ok(Person.toDTOlist(allPeople));
	}
}
