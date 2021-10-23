package com.humberto.pokemon.PokemonApp.Enums;

public enum Gender {

	MALE("Male"),
	FEMALE("Female"),
	BOTH("Both"),
	UNKNOWN("Unknown");
	
	private String value;

	private Gender(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
