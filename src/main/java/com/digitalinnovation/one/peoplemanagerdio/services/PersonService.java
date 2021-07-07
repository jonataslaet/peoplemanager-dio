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
	
	public ResponseEntity<Void> update(Long id, PersonDTO personDTO) {
		Person foundPerson = findOneById(id);
		if (foundPerson == null) {
			return ResponseEntity.notFound().build();
		}
		Person newPerson = new Person(personDTO);
		personRepository.save(getUpdatedPerson(foundPerson, newPerson));
		return ResponseEntity.noContent().build();
	}
	
	private Person getUpdatedPerson(Person updatedPerson, Person newPerson) {
		if (newPerson.getBirthDate() != null){
			updatedPerson.setBirthDate(newPerson.getBirthDate());
		}
		if (newPerson.getCpf() != null && !newPerson.getCpf().isBlank()){
			updatedPerson.setCpf(newPerson.getCpf());
		}
		if (newPerson.getFirstName() != null && !newPerson.getFirstName().isBlank()){
			updatedPerson.setBirthDate(newPerson.getBirthDate());
		}
		if (newPerson.getLastName() != null && !newPerson.getLastName().isBlank()){
			updatedPerson.setLastName(newPerson.getLastName());
		}
		if (newPerson.getPhones() != null && !newPerson.getPhones().isEmpty()){
			updatedPerson.setPhones(newPerson.getPhones());
		}
		return updatedPerson;
	}

	public ResponseEntity<Void> deleteById(Long id) {
		Person foundPerson = findOneById(id);
		if (foundPerson == null) {
			return ResponseEntity.notFound().build();
		}
		personRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
