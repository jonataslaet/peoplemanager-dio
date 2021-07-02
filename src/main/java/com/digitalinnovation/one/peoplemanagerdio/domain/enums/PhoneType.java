package com.digitalinnovation.one.peoplemanagerdio.domain.enums;

public enum PhoneType {

	HOME("Home"),
	MOBILE("Mobile"),
	COMMERCIAL("Commercial");
	
	private final String description;

	private PhoneType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
