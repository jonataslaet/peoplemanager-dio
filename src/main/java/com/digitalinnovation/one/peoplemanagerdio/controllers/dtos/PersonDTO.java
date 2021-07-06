package com.digitalinnovation.one.peoplemanagerdio.controllers.dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.digitalinnovation.one.peoplemanagerdio.domain.Person;

public class PersonDTO {

	private Long id;
	
	@NotEmpty
	@Size(min = 5, max=60)
	private String firstName;
	
	@NotEmpty
	@Size(min = 5, max=60)
	private String lastName;
	
	@NotEmpty
	@Size(min = 11, max=14)
	private String cpf;
	
	private LocalDate birthDate;
	
	@Valid
	private List<PhoneDTO> phones;

	public PersonDTO() {
		
	}
	
	public PersonDTO(Person foundPerson) {
		this.id = foundPerson.getId();
		this.firstName = foundPerson.getFirstName();
		this.lastName = foundPerson.getLastName();
		this.cpf = foundPerson.getCpf();
		this.birthDate = foundPerson.getBirthDate();
		this.phones = foundPerson.getPhones().stream().map(p -> new PhoneDTO(p)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<PhoneDTO> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}

}
