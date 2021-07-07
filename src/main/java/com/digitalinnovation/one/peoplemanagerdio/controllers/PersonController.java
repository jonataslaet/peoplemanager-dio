package com.digitalinnovation.one.peoplemanagerdio.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinnovation.one.peoplemanagerdio.controllers.dtos.PersonDTO;
import com.digitalinnovation.one.peoplemanagerdio.services.PersonService;

@RestController
@RequestMapping("/people")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonDTO> find(@PathVariable("id") Long id){
		return personService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<PersonDTO> insert(@RequestBody @Valid PersonDTO person){
		return personService.insert(person);
	}
	
	@GetMapping
	public ResponseEntity<List<PersonDTO>> findAll(){
		return personService.findAll();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody @Valid PersonDTO personDTO){
		return personService.update(id, personDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
		return personService.deleteById(id);
	}
}
