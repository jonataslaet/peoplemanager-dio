package com.digitalinnovation.one.peoplemanagerdio.controllers.dtos;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.digitalinnovation.one.peoplemanagerdio.domain.Phone;
import com.digitalinnovation.one.peoplemanagerdio.domain.enums.PhoneType;

public class PhoneDTO {

	private Long id;
	
	@Enumerated(EnumType.STRING)
	private PhoneType type;
	
	@NotEmpty
	@Size(min = 5, max=10)
	private String number;
	
	public PhoneDTO() {
	}
	
	public PhoneDTO(Long id, PhoneType type, String number) {
		this.id = id;
		this.type = type;
		this.number = number;
	}

	public PhoneDTO(Phone phone) {
		this.id = phone.getId();
		this.type = phone.getType();
		this.number = phone.getNumber();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
