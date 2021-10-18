package com.humberto.pokemon.PokemonApp.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.humberto.pokemon.PokemonApp.Enums.CategoryMove;

@Entity
public class Move {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ManyToOne
	private Type type;
	private CategoryMove category;
	private Long power;
	private Integer accuracy;
	
	public Move() {
	}

	public Move(String name, Type type, CategoryMove category, Long power, Integer accuracy) {
		this.name = name;
		this.type = type;
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
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
	
}
