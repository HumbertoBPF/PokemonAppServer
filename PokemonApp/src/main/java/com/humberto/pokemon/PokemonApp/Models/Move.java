package com.humberto.pokemon.PokemonApp.Models;

import static com.humberto.pokemon.PokemonApp.Util.Tools.listOfTypesAsString;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.humberto.pokemon.PokemonApp.Enums.CategoryMove;

@Entity
public class Move {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ManyToMany
	private List<Type> type;
	@Enumerated(EnumType.STRING)
	private CategoryMove category;
	private Long power;
	private Integer accuracy;
	
	public Move() {
	}

	public Move(Long id, String name, CategoryMove category, Long power, Integer accuracy) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.power = power;
		this.accuracy = accuracy;
	}
	
	public Move(String name, CategoryMove category, Long power, Integer accuracy) {
		this.name = name;
		this.category = category;
		this.power = power;
		this.accuracy = accuracy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Type> getType() {
		return type;
	}

	public void setType(List<Type> type) {
		this.type = type;
	}

	public CategoryMove getCategory() {
		return category;
	}

	public void setCategory(CategoryMove category) {
		this.category = category;
	}

	public Long getPower() {
		return power;
	}

	public void setPower(Long power) {
		this.power = power;
	}

	public Integer getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(Integer accuracy) {
		this.accuracy = accuracy;
	}
	
	public String toStringTypes() {
		return listOfTypesAsString(this.getType());
	}
	
}
