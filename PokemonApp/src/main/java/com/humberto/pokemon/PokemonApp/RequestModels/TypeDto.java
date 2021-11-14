package com.humberto.pokemon.PokemonApp.RequestModels;

import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humberto.pokemon.PokemonApp.Models.Type;
import com.humberto.pokemon.PokemonApp.Repositories.TypeRepository;

public class TypeDto extends Dto{
	
	private Long fId;
	@NotBlank
	private String fName;
	
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

	@Override
	public Object toEntity(JpaRepository repository) {
		if (fId == null) {
			return new Type(fName); 
		}
		TypeRepository typeRepository = (TypeRepository) repository;
		Type type = typeRepository.getById(fId);
		return new Type(fId, fName, type.getEffective(), type.getNotEffective(), type.getNoEffect());
	}

	@Override
	public void fromEntity(Object entity) {
		Type type = (Type) entity;
		this.fId = type.getId();
		this.fName = type.getName();
	}
	
}
