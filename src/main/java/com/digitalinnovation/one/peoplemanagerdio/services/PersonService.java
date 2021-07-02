package com.digitalinnovation.one.peoplemanagerdio.services;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.digitalinnovation.one.peoplemanagerdio.domain.Person;
import com.digitalinnovation.one.peoplemanagerdio.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public ResponseEntity<Person> insert(Person person) {

		Person savedPerson = personRepository.save(person);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPerson.getId())
				.toUri();

		return ResponseEntity.created(uri).body(savedPerson);
	}

	public ResponseEntity<Person> findById(Long id) {
		Person foundPerson = findOneById(id);
		if (foundPerson == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(foundPerson);
	}

	private Person findOneById(Long id) {
		Optional<Person> foundPerson = personRepository.findById(id);

		if (!foundPerson.isPresent()) {
			return null;
		}

		return foundPerson.get();
	}
}
