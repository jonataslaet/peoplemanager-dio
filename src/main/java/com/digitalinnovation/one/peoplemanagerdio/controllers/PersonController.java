package com.digitalinnovation.one.peoplemanagerdio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinnovation.one.peoplemanagerdio.domain.Person;
import com.digitalinnovation.one.peoplemanagerdio.services.PersonService;

@RestController
@RequestMapping("/people")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping
	public String getBook() {
		return "API Test!";
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> find(@PathVariable("id") Long id){
		return personService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Person> insert(@RequestBody Person person){
		return personService.insert(person);
	}
}
