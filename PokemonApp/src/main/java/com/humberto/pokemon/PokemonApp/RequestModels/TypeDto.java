package com.humberto.pokemon.PokemonApp.RequestModels;

import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humberto.pokemon.PokemonApp.Models.Type;
import com.humberto.pokemon.PokemonApp.Repositories.TypeRepository;

public class TypeDto extends Dto{
	
	private Long fId;
	@NotBlank
	private String fName;
	@NotBlank
	private String fColorCode;
	
	public TypeDto() {
	}

	public TypeDto(Long fId, String fName) {
		this.fId = fId;
		this.fName = fName;
	}
	
	public Long getfId() {
		return fId;
	}

	public void setfId(Long fId) {
		this.fId = fId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getfColorCode() {
		return fColorCode;
	}

	public void setfColorCode(String fColorCode) {
		this.fColorCode = fColorCode;
	}

	@Override
	public Object toEntity(JpaRepository repository) {
		if (fId == null) {
			return new Type(fName,fColorCode); 
		}
		TypeRepository typeRepository = (TypeRepository) repository;
		Type type = typeRepository.getById(fId);
		return new Type(fId, fName, fColorCode, type.getEffective(), type.getNotEffective(), type.getNoEffect());
	}

	@Override
	public void fromEntity(Object entity) {
		Type type = (Type) entity;
		this.fId = type.getId();
		this.fName = type.getName();
		this.fColorCode = type.getColorCode();
	}
	
}
