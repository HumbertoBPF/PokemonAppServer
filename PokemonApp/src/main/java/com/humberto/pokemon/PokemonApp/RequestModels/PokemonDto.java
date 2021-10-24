package com.humberto.pokemon.PokemonApp.RequestModels;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humberto.pokemon.PokemonApp.Enums.Gender;
import com.humberto.pokemon.PokemonApp.Models.Pokemon;
import com.humberto.pokemon.PokemonApp.Repositories.PokemonRepository;

public class PokemonDto extends Dto{

	private Long fId;
	@NotBlank
	private String fName;
	@NotBlank
	private String fDescription;
	@NotNull
	@Min(0)
	private Double fHeight;
	@NotNull
	@Min(0)
	private Double fWeight;
	@NotBlank
	private String fGender;
	@NotBlank
	private String fCategory;
	@NotNull
	@PositiveOrZero
	private Integer fAttack;
	@NotNull
	@PositiveOrZero
	private Integer fDefense;
	@NotNull
	@PositiveOrZero
	private Integer fSpAttack;
	@NotNull
	@PositiveOrZero
	private Integer fSpDefense;
	@NotNull
	@PositiveOrZero
	private Integer fSpeed;
	@NotNull
	@PositiveOrZero
	private Integer fHp;

	public PokemonDto(Long fId, String fName, String fDescription, Double fHeight, Double fWeight, String fGender,
			String fCategory, Integer fAttack, Integer fDefense, Integer fSpAttack, Integer fSpDefense, Integer fSpeed,
			Integer fHp) {
		this.fId = fId;
		this.fName = fName;
		this.fDescription = fDescription;
		this.fHeight = fHeight;
		this.fWeight = fWeight;
		this.fGender = fGender;
		this.fCategory = fCategory;
		this.fAttack = fAttack;
		this.fDefense = fDefense;
		this.fSpAttack = fSpAttack;
		this.fSpDefense = fSpDefense;
		this.fSpeed = fSpeed;
		this.fHp = fHp;
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
	
	public String getfDescription() {
		return fDescription;
	}
	
	public void setfDescription(String fDescription) {
		this.fDescription = fDescription;
	}
	
	
	public Double getfHeight() {
		return fHeight;
	}
	
	public void setfHeight(Double fHeight) {
		this.fHeight = fHeight;
	}
	
	public Double getfWeight() {
		return fWeight;
	}
	
	public void setfWeight(Double fWeight) {
		this.fWeight = fWeight;
	}
	
	public String getfGender() {
		return fGender;
	}
	
	public void setfGender(String fGender) {
		this.fGender = fGender;
	}
	
	public String getfCategory() {
		return fCategory;
	}
	
	public void setfCategory(String fCategory) {
		this.fCategory = fCategory;
	}
	
	public Integer getfAttack() {
		return fAttack;
	}
	
	public void setfAttack(Integer fAttack) {
		this.fAttack = fAttack;
	}
	
	public Integer getfDefense() {
		return fDefense;
	}
	
	public void setfDefense(Integer fDefense) {
		this.fDefense = fDefense;
	}
	
	public Integer getfSpAttack() {
		return fSpAttack;
	}
	
	public void setfSpAttack(Integer fSpAttack) {
		this.fSpAttack = fSpAttack;
	}
	
	public Integer getfSpDefense() {
		return fSpDefense;
	}
	
	public void setfSpDefense(Integer fSpDefense) {
		this.fSpDefense = fSpDefense;
	}
	
	public Integer getfSpeed() {
		return fSpeed;
	}
	
	public void setfSpeed(Integer fSpeed) {
		this.fSpeed = fSpeed;
	}
	
	public Integer getfHp() {
		return fHp;
	}
	
	public void setfHp(Integer fHp) {
		this.fHp = fHp;
	}
	
	private Gender toGender(String genderString) {
		if (genderString.equals(Gender.MALE.getValue())) {
			return Gender.MALE;
		}else if (genderString.equals(Gender.FEMALE.getValue())) {
			return Gender.FEMALE;
		}else if (genderString.equals(Gender.BOTH.getValue())) {
			return Gender.BOTH;
		}else if (genderString.equals(Gender.UNKNOWN.getValue())) {
			return Gender.UNKNOWN;
		}
		return null;
	}

	@Override
	public Object toEntity(JpaRepository repository) {
		if (fId == null) {
			return new Pokemon(fName,fDescription,fHeight,fWeight,toGender(fGender),fCategory,fAttack,fDefense,fSpAttack,fSpDefense,fSpeed,fHp);
		}
		PokemonRepository pokemonRepository = (PokemonRepository) repository;
		Pokemon pokemon = pokemonRepository.getById(fId);
		return new Pokemon(fId,fName,fDescription,fHeight,fWeight,toGender(fGender),pokemon.getType(),
				fCategory,fAttack,fDefense,fSpAttack,fSpDefense,fSpeed,fHp,pokemon.getMoves());
	}

	@Override
	public void fromEntity(Object entity) {
		Pokemon pokemon = (Pokemon) entity;
		this.fId = pokemon.getId();
		this.fName = pokemon.getName();
		this.fDescription = pokemon.getDescription();
		this.fHeight = pokemon.getHeight();
		this.fWeight = pokemon.getWeight();
		this.fGender = pokemon.getGender().getValue();
		this.fCategory = pokemon.getCategory();
		this.fAttack = pokemon.getAttack();
		this.fDefense = pokemon.getDefense();
		this.fSpAttack = pokemon.getSpAttack();
		this.fSpDefense = pokemon.getSpDefense();
		this.fSpeed = pokemon.getSpeed();
		this.fHp = pokemon.getHp();
	}
	
}
